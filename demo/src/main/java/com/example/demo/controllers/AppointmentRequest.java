package com.example.demo.controllers;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.Patient;

public class AppointmentRequest extends RepresentationModel<AppointmentRequest> {
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	private Patient patient;
}
