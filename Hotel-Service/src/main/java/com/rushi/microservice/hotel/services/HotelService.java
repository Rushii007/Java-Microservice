/**
 * 
 */
package com.rushi.microservice.hotel.services;

import java.util.List;

import com.rushi.microservice.hotel.entities.Hotel;

/**
 * 
 */
public interface HotelService {

	public Hotel saveHotel(Hotel hotel);
	public List<Hotel> getAllHotels();
	public Hotel getHotelById(String hotelId);
}
