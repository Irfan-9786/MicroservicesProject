package com.iastech.rating.service.controllers;

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

import com.iastech.rating.service.entities.Rating;
import com.iastech.rating.service.services.RatingServices;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingServices ratingServices;

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating rating2 = ratingServices.createRating(rating);
		//System.out.println("just checking");
//123
//0000
//4444
//2222
		return ResponseEntity.status(HttpStatus.CREATED).body(rating2);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> getAllRatings = ratingServices.getAllRatings();
		return ResponseEntity.ok(getAllRatings);
	}

	@GetMapping("/userId/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> getRatingByUserId = ratingServices.getRatingByUserId(userId);
		return ResponseEntity.ok(getRatingByUserId);
	}

	@GetMapping("/hotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> getRatingByHotelId = ratingServices.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(getRatingByHotelId);
	}

}
