package com.iastech.hotel.service.services;

import java.util.List;

import com.iastech.hotel.service.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(String id);
	List<Hotel> getHotelByLocation(String location);
}
