package com.course.practicaljava.service;

import java.util.List;

import com.course.practicaljava.domain.Car;

public interface CarService {
	List<String> BRANDS = List.of("Toyota","Honda","Ford","Hyundai","Renault","Audi","BMW");
	List<String> COLORS = List.of("Red","Black","White","Dark Blue","Grey");
	List<String> TYPES = List.of("Sedan","SUV","MPV","Crossover","Coupe","Hatchback");
	List<String> ADDITONAL_FEATURES = List.of("GPS","Alarm","Sunroof","Media Player", "Leather seats");
	
	public Car generateCar();
	
}
