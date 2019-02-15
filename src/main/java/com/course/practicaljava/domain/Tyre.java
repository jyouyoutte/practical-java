package com.course.practicaljava.domain;

public class Tyre {
	String manufacturer;
	int price, size;
	
	public Tyre() {
		super();
	}
	public Tyre(String manufacturer, int price, int size) {
		super();
		this.manufacturer = manufacturer;
		this.price = price;
		this.size = size;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getPrice() {
		return price;
	}
	public int getSize() {
		return size;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Tyre [manufacturer=" + manufacturer + ", price=" + price + ", size=" + size + "]";
	}
	
	
}
