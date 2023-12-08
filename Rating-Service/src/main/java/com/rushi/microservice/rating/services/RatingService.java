/**
 * 
 */
package com.rushi.microservice.rating.services;

import java.util.List;

import com.rushi.microservice.rating.entities.Rating;

/**
 * 
 */
public interface RatingService {

	public Rating saveRating(Rating rating);
	public List<Rating> getAllRatings();
	public List<Rating> getRatingByUserId(String userId);
	public List<Rating> getRatingByHotelId(String hotelId);
}
