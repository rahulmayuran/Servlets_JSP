package com.servletAnn.Entity;

//An entity class to get mapped to the JSP's
public class NavyOfficer {

	private int id;
	private String name;
	private int age;
	private String designation;

	public NavyOfficer(int id, String name, int age, String designation) {
		super();
		this.age = age;
		this.designation = designation;
		this.id = id;
		this.name = name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NavyOfficer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", Designation=");
		builder.append(designation);
		builder.append("]");

		return builder.toString();
	}

}
