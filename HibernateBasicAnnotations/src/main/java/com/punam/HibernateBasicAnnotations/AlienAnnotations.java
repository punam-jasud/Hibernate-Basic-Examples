package com.punam.HibernateBasicAnnotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity(name = "alienTable")
//@Table(name = "alienTable")

@Entity
public class AlienAnnotations {

	@Id
	@Column(name="AlienID")
	private int aid;
	
	@Column(name="AlienName")
	private String aname;
	
	@Transient
	@Column(name="AlienColor")
	private String color;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
		
}
