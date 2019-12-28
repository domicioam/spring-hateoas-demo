package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.demo.Slot;
import com.example.demo.SlotRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	private SlotRepository slotRepository;

	@GetMapping("/{id}")
	public ResponseEntity<CollectionModel<EntityModel<Slot>>> findAllOpenSlotsForDoctor(@PathVariable String id, @RequestBody String date) {
		if(id == null || date == null) {
			throw new IllegalArgumentException();
		}
		
		List<Slot> openSlots = slotRepository.findAllOpenSlotsByDoctorAndDate(id, date);
		List<EntityModel<Slot>> slotResources = new ArrayList<EntityModel<Slot>>();
		
		for(Slot slot : openSlots) {
			
			EntityModel<Slot> entityModel = new EntityModel<>(slot, linkTo(methodOn(SlotController.class).findById(slot.getId())).withSelfRel()
					.andAffordance(afford(methodOn(SlotController.class).save(slot.getId(), null))))
			.add(linkTo(methodOn(SlotController.class).save(slot.getId(), null)).withRel("/linkrels/slot/book"));
					
			
			slotResources.add(entityModel);
		}
		
		return ResponseEntity.ok(new CollectionModel<>(slotResources,
				linkTo(methodOn(DoctorController.class).findAllOpenSlotsForDoctor(id, null)).withSelfRel()));
	}
	
	public DoctorController() {
		super();
		this.slotRepository = new SlotRepository();
	}
}
