package com.punam.EmbeddabbleObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlienEmbeddable {

	@Id
	private int aid;
	private AlienName aname;
	private String color;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "AlienEmbeddable [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	
	
}
