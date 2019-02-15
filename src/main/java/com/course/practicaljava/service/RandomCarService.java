package com.course.practicaljava.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.course.practicaljava.domain.Car;
import com.course.practicaljava.domain.Engine;
import com.course.practicaljava.domain.Tyre;
import com.course.practicaljava.util.RandomDateUtil;

@Service
public class RandomCarService implements CarService {
	
	private Random random = new Random();

	@Override
	public Car generateCar() {

		var randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		var randomColor = COLORS.get(random.nextInt(COLORS.size()));
		var randomType = TYPES.get(random.nextInt(TYPES.size()));
		var randomCount = random.nextInt(ADDITONAL_FEATURES.size());
		
		var additionalFeatures = new ArrayList<String>();
		for (int i = 1; i < randomCount; i++) {
			additionalFeatures.add(ADDITONAL_FEATURES.get(i-1));
		}
		
		
		var randomFuelType = FUEL_TYPES.get(random.nextInt(FUEL_TYPES.size()));		
		var randomHorsePower = 100 + random.nextInt(121);
		
		var randomEngine = new Engine(randomFuelType, randomHorsePower);
		
	
		var randomCompatibleTyres = new ArrayList<Tyre>();
		for (int i = 0; i < TYRE_MANUFACTURERS.size(); i++) {
			var tyreManufacturer = TYRE_MANUFACTURERS.get(random.nextInt(TYRE_MANUFACTURERS.size()));
			var tyreSize = 15 + random.nextInt(3);
			var tyrePrice = 200 + random.nextInt(201);			
			randomCompatibleTyres.add(new Tyre(tyreManufacturer, tyrePrice, tyreSize));
		}
		
		
		Car car = new Car(randomBrand,randomColor,randomType, 500 + random.nextInt(7000) ,random.nextBoolean(), RandomDateUtil.generateRandomDate());	
		car.setAdditionalFeatures(additionalFeatures);		
		car.setEngine(randomEngine);
		car.setCompatibleTyres(randomCompatibleTyres);
		return 	car;
		 
	}

}
