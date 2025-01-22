package com.iastech.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.iastech.hotel.service.entities.Hotel;
import com.iastech.hotel.service.exceptions.ResourceNotFoundException;
import com.iastech.hotel.service.repositories.HotelRepository;
import com.iastech.hotel.service.services.HotelService;
@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomId=UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> allHostels=hotelRepository.findAll();
		return allHostels;
	}

	@Override
	public Hotel getHotelById(String id) {
		Hotel hotel=hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with ID =\""+id+"\" not exist in Database...!!!"));
		return hotel;
	}

	@Override
	public List<Hotel> getHotelByLocation(String location) {
		List<Hotel> hotel =hotelRepository.findByLocation(location);
		if(hotel.isEmpty()) {
			throw new ResourceNotFoundException("Hotel having LOCATION = "+location+", does not exist in database...!!! ");
		}
		return hotel;
	}

}
