package com.punam.EagerFetchTechnique;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AlienEager {

	@Id
	private int aid;
	private String aname;
	
	@OneToMany(mappedBy = "alien",fetch = FetchType.EAGER)
	private Collection<LaptopEagar> laps = new ArrayList<LaptopEagar>();
	
	
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
	
	public Collection<LaptopEagar> getLaps() {
		return laps;
	}
	public void setLaps(Collection<LaptopEagar> laps) {
		this.laps = laps;
	}
	@Override
	public String toString() {
		return "AlienEager [aid=" + aid + ", aname=" + aname + ", laps=" + laps + "]";
	}
	
}
