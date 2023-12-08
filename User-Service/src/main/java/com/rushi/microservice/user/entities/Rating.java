/**
 * 
 */
package com.rushi.microservice.user.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private Integer ratingDigit;
	private String feedback;
	
	private Hotel hotel;
}
