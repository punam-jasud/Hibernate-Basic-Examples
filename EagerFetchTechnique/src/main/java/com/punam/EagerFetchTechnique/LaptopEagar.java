package com.punam.EagerFetchTechnique;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LaptopEagar {
	
	@Id
	private int lid;
	private String lname;
	private int price;
	
	@ManyToOne
	private AlienEager alien;
	
	public int getLid() {
		return lid;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public AlienEager getAlien() {
		return alien;
	}
	public void setAlien(AlienEager alien) {
		this.alien = alien;
	}
	@Override
	public String toString() {
		return "LaptopEagar [lid=" + lid + ", lname=" + lname + ", price=" + price + ", alien=" + alien + "]";
	}
	
	
}
