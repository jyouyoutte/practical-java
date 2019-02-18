package com.course.practicaljava.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.course.practicaljava.domain.Car;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car, String> {
	
	public List<Car> findByBrandAndColor(String brand, String color);

	/**
	 * returns list of cars which release date is after the param date
	 * @param date
	 * @return 
	 */
	@Query("{ \"range\":{ \"first_release_date\":{ \"gt\":?0 } } }")
	public List<Car> findByFirstReleaseDateAfter(long date);

}
