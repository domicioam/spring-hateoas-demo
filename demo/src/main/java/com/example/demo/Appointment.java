package com.example.demo;

public class Appointment {
	
	public Appointment() {
		super();
	}
	public Appointment(Slot slot, Patient patient) {
		super();
		this.slot = slot;
		this.patient = patient;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	private Slot slot;
	private Patient patient;
}