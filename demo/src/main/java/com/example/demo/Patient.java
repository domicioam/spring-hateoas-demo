package com.example.demo;

public class Patient {
	
	public Patient() {
		super();
	}

	public Patient(String id) {
		super();
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}