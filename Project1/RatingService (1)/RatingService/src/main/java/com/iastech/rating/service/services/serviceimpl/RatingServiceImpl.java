package com.iastech.rating.service.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iastech.rating.service.entities.Rating;
import com.iastech.rating.service.repositories.RatingRepository;
import com.iastech.rating.service.services.RatingServices;
@Service
public class RatingServiceImpl implements RatingServices {

	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating createRating(Rating rating) {
	Rating rating1 =ratingRepository.save(rating);
		return rating1;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> allRatings=ratingRepository.findAll();
		return allRatings;
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating> ratingByUserId= ratingRepository.findByUserId(userId);
		return ratingByUserId;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		List<Rating> ratingByHotelId= ratingRepository.findByHotelId(hotelId);
		return ratingByHotelId;
	}

}
