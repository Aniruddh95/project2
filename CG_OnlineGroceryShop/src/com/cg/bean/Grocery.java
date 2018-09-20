package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Grocery {
	
	@Id
	@SequenceGenerator(name="sequence", sequenceName="seq")
	@GeneratedValue(generator="sequence")
	private int id;
	private String name;
	private float price;
	private String category;
	private int quantity;
	private String unit;
	private String description;
	public Grocery(int id, String name, float price, String category,
			int quantity, String unit, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
	}
	public Grocery() {
		super();
		
	}
	@Override
	public String toString() {
		return "Grocery [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", quantity=" + quantity
				+ ", unit=" + unit + ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//@NotEmpty(message="Item name is required")
	@Pattern(regexp="[a-zA-Z]+",message="Enter valid data")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	//@Pattern(regexp="[1-10]",message="Please use only digits")
	
	
	@DecimalMin(value="1.0", message="Enter valid data")
	public float getPrice() {
		return price;
	}
	

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Pattern(regexp="^(?:(?!Select).)*$",message="Select Options")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//@Pattern(regexp="[1-10]",message="Please use only digits")
	@Min(1)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Pattern(regexp="[a-zA-Z]+",message="Please enter valid data")
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@NotEmpty(message="Item name is required")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
