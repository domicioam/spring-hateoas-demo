package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.Link;

import com.example.demo.Appointment;
import com.example.demo.AppointmentRepository;
import com.example.demo.Slot;
import com.example.demo.SlotRepository;

@RestController
@RequestMapping("/slot")
public class SlotController {
	private AppointmentRepository appointmentRepository;
	private SlotRepository slotRepository;
	
	@GetMapping("/{id}")
	public Slot findById(@PathVariable String id) {
		return new Slot();
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Appointment save(@PathVariable String id, @RequestBody AppointmentRequest request) {
		Slot slot = null;
		
		for(Slot s : slotRepository.findAll()) { // move into repository
			if(s.getId().equals(id)) {
				slot = s;
			}
		}
		
		Appointment appointment = new Appointment();
		appointment.setPatient(request.getPatient());
		appointment.setSlot(slot);
		appointmentRepository.add(appointment);

		Link selfRel = linkTo(methodOn(SlotController.class).findById(id)).withSelfRel();
		selfRel.andAffordance(afford(methodOn(SlotController.class).update(id, null))); // make it works
		
		Link updateLink = linkTo(methodOn(SlotController.class).update(id, null)).withRel("/slot/update");
		
		//appointment.add(selfRel);
		//appointment.add(updateLink);
		return appointment;
	}
	
	@PutMapping("/{id}")
	public Appointment update(@PathVariable String id, @RequestBody AppointmentRequest request) {
		Slot slot = null;
		
		for(Slot s : slotRepository.findAll()) { // move into repository
			if(s.getId().equals(id)) {
				slot = s;
			}
		}
		
		Appointment appointment = new Appointment();
		appointment.setPatient(request.getPatient());
		appointment.setSlot(slot);
		appointmentRepository.add(appointment);
		return appointment;
	}
	
	public SlotController() {
		super();
		this.appointmentRepository = new AppointmentRepository();
		this.slotRepository = new SlotRepository();
	}
}
