package com.course.practicaljava.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.domain.Car;
import com.course.practicaljava.repository.CarElasticRepository;
import com.course.practicaljava.service.CarService;

@RestController
@RequestMapping("/api/car/v1")
public class CarRestController {
	
		private Logger log = LoggerFactory.getLogger(CarRestController.class);
		private Random random = new Random();

		@Autowired
		private CarService carService;
		
		@Autowired
		private CarElasticRepository carElasticRepository;
		
		//@RequestMapping(path="/random", method = RequestMethod.GET)
		@GetMapping(path="/random", produces = MediaType.APPLICATION_JSON_VALUE)
		public Car random() {
			return carService.generateCar();
		}
		
		@PostMapping(path ="/echo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
		public String echo (@RequestBody Car car) {
			log.info("The car is : " + car);		
			return car.toString();			
		}
		
		@GetMapping(path = "/random-cars", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Car> randomCars(){
			var result = new ArrayList<Car>();
			for (int i = 0; i < random.nextInt(6); i++) {
				result.add(carService.generateCar());
			}
			return result;			
		}
		
		@GetMapping(path = "/cars/count")
		public long countCar() {
			long cont = carElasticRepository.count();
			log.info("Number of cars : " +  cont);
			return cont;
		}
		
		@PostMapping(path = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
		public Car createCar(@RequestBody Car car) {
			return carElasticRepository.save(car);
		}
		

		@GetMapping(path = "/cars/{id}")
		public Car findCarsById(@PathVariable String id) {
			return carElasticRepository.findById(id).orElse(null);
		}
		
		@PutMapping(path = "/cars/{id}")
		public Car updateCarById(@PathVariable String id, @RequestBody Car updatedCar) {
			updatedCar.setId(id);
			return carElasticRepository.save(updatedCar);
		}

		@GetMapping(path = "/cars/{brand}/{color}")
		public List<Car> findCarsByPath(@PathVariable String brand, @PathVariable String color) {
			return carElasticRepository.findByBrandAndColor(brand, color);
		}

		@GetMapping(path = "/cars")
		public List<Car> findCarsByParam(@RequestParam String brand, @RequestParam String color) {
			
			List<Car> carsList= carElasticRepository.findByBrandAndColor(brand, color);
			log.info("Car found " + carsList.size());			
			return carsList;
		}

		@GetMapping(path = "/cars/date")
		public List<Car> findCarsReleasedAfter(
				@RequestParam(name = "first_release_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date firstReleaseDate) {
			var carFound = carElasticRepository.findByFirstReleaseDateAfter(firstReleaseDate.getTime());
			log.info("Car found ");
			log.info(carFound.toString());
			return carFound;
		}

		
}
