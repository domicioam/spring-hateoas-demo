package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
	private List<Appointment> appointments = new ArrayList<Appointment>();

	public Appointment add(Appointment appointment) {
		appointments.add(appointment);
		return appointment;
	}
}
