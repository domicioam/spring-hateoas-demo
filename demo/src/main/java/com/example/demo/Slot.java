package com.example.demo;

public class Slot {
	private String id;

	public Slot(String start, String end, Doctor doctor, String id) {
		super();
		this.start = start;
		this.end = end;
		this.doctor = doctor;
		this.id = id;
	}
	
	public Slot() {
		super();
	}

	private String start;
	private String end;
	private Doctor doctor;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}