package com.iastech.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iastech.hotel.service.entities.Hotel;
import com.iastech.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1=	hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> allHotels=hotelService.getAllHotels();
		return ResponseEntity.ok(allHotels);
	}
	@GetMapping("/hotelId/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
		Hotel hotel=hotelService.getHotelById(id);
		return ResponseEntity.ok(hotel);
	}
	@GetMapping("/location/{loc}")
	public ResponseEntity<List<Hotel>> getHotelByLocation(@PathVariable String loc){
		List<Hotel> hotel=hotelService.getHotelByLocation(loc);
		return ResponseEntity.ok(hotel);
	}
}
