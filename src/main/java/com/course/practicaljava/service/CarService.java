package com.course.practicaljava.service;

import java.util.List;

import com.course.practicaljava.domain.Car;

public interface CarService {
	List<String> BRANDS = List.of("Toyota","Honda","Ford","Hyundai","Renault","Audi","BMW");
	List<String> COLORS = List.of("Red","Black","White","Dark Blue","Grey");
	List<String> TYPES = List.of("Sedan","SUV","MPV","Crossover","Coupe","Hatchback");
	List<String> ADDITONAL_FEATURES = List.of("GPS","Alarm","Sunroof","Media Player", "Leather seats");
	List<String> FUEL_TYPES = List.of("Petrol","Electric","Hybrid","Hydrogen","BioEthanol","GPL");
	List<String> TYRE_MANUFACTURERS =  List.of("Goodyear","Michelin","Dunlop","Bridgestone");
	
	public Car generateCar();
	
}
