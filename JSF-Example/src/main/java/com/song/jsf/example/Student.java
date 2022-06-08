package com.song.jsf.example;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public Student() {}
	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Override
	public Student clone() {
		return new Student(id, name);
	}

	public void restore(Student student) {
		this.id = student.getId();
		this.name = student.getName();
	}
}
