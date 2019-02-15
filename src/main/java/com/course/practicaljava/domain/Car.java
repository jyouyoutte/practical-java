package com.course.practicaljava.domain;

import java.util.Date;
import java.util.List;

public class Car {
	private String brand, color, type;
	private int price;
	private boolean available;
	private Date firstReleaseDate;
	private List<String> additionalFeatures;
	
	private Engine engine;
	private List<Tyre> compatibleTyres;
	
	public Car(){}

	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	}

	public Car(String brand, String color, String type, int price, boolean available, Date firstReleaseDate) {
		this(brand, color, type);	
		this.price = price;
		this.available = available;
		this.firstReleaseDate = firstReleaseDate;
	}

	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public List<Tyre> getCompatibleTyres() {
		return compatibleTyres;
	}

	public Engine getEngine() {
		return engine;
	}

	public Date getfirstReleaseDate() {
		return firstReleaseDate;
	}
	
	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCompatibleTyres(List<Tyre> compatibleTyres) {
		this.compatibleTyres = compatibleTyres;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setfirstReleaseDate(Date firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	public void setFirstReleaseDate(Date firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + ", price=" + price + ", available="
				+ available + ", firstReleaseDate=" + firstReleaseDate + "]";
	}

	
}
