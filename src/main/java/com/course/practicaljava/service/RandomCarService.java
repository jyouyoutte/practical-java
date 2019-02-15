package com.course.practicaljava.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.course.practicaljava.domain.Car;

@Service
public class RandomCarService implements CarService {
	
	private Random random = new Random();

	@Override
	public Car generateCar() {

		var randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		var randomColor = COLORS.get(random.nextInt(COLORS.size()));
		var randomType = TYPES.get(random.nextInt(TYPES.size()));
		
		return new Car(randomBrand,randomColor,randomType);		
		 
	}

}
