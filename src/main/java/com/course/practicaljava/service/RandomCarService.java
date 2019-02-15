package com.course.practicaljava.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.course.practicaljava.domain.Car;
import com.course.practicaljava.util.RandomDateUtil;

@Service
public class RandomCarService implements CarService {
	
	private Random random = new Random();

	@Override
	public Car generateCar() {

		var randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		var randomColor = COLORS.get(random.nextInt(COLORS.size()));
		var randomType = TYPES.get(random.nextInt(TYPES.size()));		
		
		
		return new Car(randomBrand,randomColor,randomType, 500 + random.nextInt(7000) ,random.nextBoolean(), RandomDateUtil.generateRandomDate());		
		 
	}

}
