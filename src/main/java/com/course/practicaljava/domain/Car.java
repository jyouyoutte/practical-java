package com.course.practicaljava.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(indexName = "practical-java", type = "car")
public class Car {
	private String brand, color, type;
	@JsonIgnore
	private int price;
	private boolean available;
	
	@Id
	private String id;
	
	@JsonFormat(pattern = "dd-MM-yyyy@HH:mm:ss.SSSZ", timezone = "Europe/Paris")
	@Field(type = FieldType.Date, format = DateFormat.date_time)
	private Date firstReleaseDate;
	
	@JsonInclude(value = Include.NON_EMPTY)
	private List<String> additionalFeatures;
	
	@JsonUnwrapped
	private Engine engine;
	private List<Tyre> compatibleTyres;

	@JsonInclude(value = Include.NON_EMPTY)
	private String secretFeature;

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

	public String getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public String getSecretFeature() {
		return secretFeature;
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

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setSecretFeature(String secretFeature) {
		this.secretFeature = secretFeature;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + ", price=" + price + ", available="
				+ available + ", firstReleaseDate=" + firstReleaseDate + ", additionalFeatures=" + additionalFeatures
				+ ", engine=" + engine + ", compatibleTyres=" + compatibleTyres + ", secretFeature=" + secretFeature
				+ "]";
	}

	
}
