package com.ltimindtree.chatbot.model;

public class Queries {
	int id;
	String name;
	String department;
	String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Queries(int id, String name, String department, String description) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.description = description;
	}
	public Queries() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Queries [id=" + id + ", name=" + name + ", department=" + department + ", description=" + description
				+ "]";
	}
	
	
	
}
