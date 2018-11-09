package com.abd.kafka.KafkaClient.model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String standard;

	public Student() {
		super();
	}

	public Student(int id, String name, String standard) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

}
