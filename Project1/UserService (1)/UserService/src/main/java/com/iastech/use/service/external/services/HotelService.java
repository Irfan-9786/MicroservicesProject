package com.iastech.use.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iastech.use.service.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	@GetMapping("/hotels/hotelId/{id}")
	Hotel getHotel(@PathVariable String id);

}
