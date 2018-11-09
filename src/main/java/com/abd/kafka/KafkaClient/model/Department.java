package com.abd.kafka.KafkaClient.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private int id;

	private List<Employee> employees = new ArrayList<Employee>();

	public Department(int id) {
		super();
		this.id = id;
		for (int i = 0; i < 5; i++)
			employees.add(new Employee(i + 1, id + "name" + i, i * 10000));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", employees=" + employees + "]";
	}

}
