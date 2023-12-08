/**
 * 
 */
package com.rushi.microservice.user.services.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rushi.microservice.user.entities.Hotel;

/**
 * 
 */
@FeignClient(name = "HOTEL-SERVICE")
public interface CallHotelServiceExternally {

	@GetMapping("/hotels/{hotelId}")
	Hotel getHotelById(@PathVariable String hotelId);
	
}
