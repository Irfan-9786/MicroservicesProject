package com.iastech.rating.service.services;

import java.util.List;

import com.iastech.rating.service.entities.Rating;

public interface RatingServices {

	Rating createRating(Rating rating);
	List<Rating> getAllRatings();
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);
	
}
