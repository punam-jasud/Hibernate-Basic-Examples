package com.punam.Student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
//@Table(name="stud_table")
public class Stud {
	
	@Id
	private int id;
	
	//@Column(name="Stud_Name")
	private String name;
	//private StudentName name;
	
	//@Transient
	private int marks;
	
	//@OneToOne
	//private Laptop laptop;
	
	@OneToMany(mappedBy = "student")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	
	/*
	 * public Laptop getLaptop() { return laptop; } public void setLaptop(Laptop
	 * laptop) { this.laptop = laptop; }
	 */
	
	
	
	public int getId() {
		return id;
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * public StudentName getName() { return name; } public void setName(StudentName
	 * name) { this.name = name; }
	 */
	
	public int getMarks() {
		return marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Stud [id=" + id + ", name=" + name + ", marks=" + marks + ", laptop=" + laptop + "]";
	}
	
	
	
	
	

}
