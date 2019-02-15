package com.course.practicaljava.service;

import java.util.List;

import com.course.practicaljava.domain.Car;

public interface CarService {
	List<String> BRANDS = List.of("Totota","Honda","Ford","Hyundai");
	List<String> COLORS = List.of("Red","Black","White","Dark Blue");
	List<String> TYPES = List.of("Sedan","SUV","MPV");
	
	public Car generateCar();
	
}
