package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class SlotRepository {
	private List<Slot> slots = new ArrayList<Slot>();

	public SlotRepository() {
		super();
		slots.add(new Slot("1400", "1450", new Doctor("mjones"), "1234"));
		slots.add(new Slot("1600", "1650", new Doctor("mjones"), "5678"));
	}
	
	public List<Slot> findAll() {
		return slots;
	}

	public List<Slot> findAllOpenSlotsByDoctorAndDate(String id, String date) {
		List<Slot> avaiableSlots = new ArrayList<Slot>();
		for(Slot slot : findAll()) { 
			if(slot.getDoctor().getId().equals(id)) {
				avaiableSlots.add(slot);
			}
		}
		
		return avaiableSlots;
	}
	
	
}
