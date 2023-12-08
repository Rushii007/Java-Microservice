package com.rushi.microservice.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushi.microservice.rating.entities.Rating;
import com.rushi.microservice.rating.services.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		Rating rating1 = ratingService.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	} 
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {
		List<Rating> rating = ratingService.getAllRatings();
		return ResponseEntity.ok(rating);
	} 
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> rating = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(rating);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> rating = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(rating);
	}
	
}
