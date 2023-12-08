/**
 * 
 */
package com.rushi.microservice.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushi.microservice.hotel.entities.Hotel;
import com.rushi.microservice.hotel.exceptions.ResourceNotFoundException;
import com.rushi.microservice.hotel.repositories.HotelRepository;
import com.rushi.microservice.hotel.services.HotelService;

/**
 * 
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		hotel.setHotelId(UUID.randomUUID().toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found."));
	}

}
