package com.iastech.use.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iastech.use.service.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	@GetMapping("ratings/userId/{userId}")
	List<Rating> getRating(@PathVariable String userId);
}
