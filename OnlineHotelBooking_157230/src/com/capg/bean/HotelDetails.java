package com.capg.bean;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class HotelDetails {

	@Id
	private int id;
	private String name;
	private String rating;
	private int rate;
	private int availableRooms;
	
	
	
	
	
	public HotelDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelDetails(int id, String name, String rating, int rate,
			int availableRooms) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.rate = rate;
		this.availableRooms = availableRooms;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", rating=" + rating
				+ ", rate=" + rate + ", availableRooms=" + availableRooms + "]";
	}
	
	
	
}
