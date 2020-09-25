package com.punam.Student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	
	//@ManyToOne
	//private Stud student;
	

	@ManyToMany
	private List<Stud> student = new ArrayList<Stud>();
	
	/*
	 * public Stud getStudent() { return student; } public void setStudent(Stud
	 * student) { this.student = student; }
	 */
	
	public int getLid() {
		return lid;
	}
	public List<Stud> getStudent() {
		return student;
	}
	public void setStudent(List<Stud> student) {
		this.student = student;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
	
	
}
