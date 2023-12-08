/**
 * 
 */
package com.rushi.microservice.user.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rushi.microservice.user.entities.Rating;
import com.rushi.microservice.user.entities.User;
import com.rushi.microservice.user.exceptions.ResourceNotFoundException;
import com.rushi.microservice.user.repositories.UserRepository;
import com.rushi.microservice.user.services.UserService;
import com.rushi.microservice.user.services.external.CallHotelServiceExternally;

/**
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	CallHotelServiceExternally callHotelServiceExternally;
	
	@Override
	public User saveUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Record Not Found: "+ userId));
		Rating[] ratelist = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+ user.getUserId(), Rating[].class);
		List<Rating> ratingList =  Arrays.stream(ratelist).collect(Collectors.toList());
		List<Rating> collectedList = ratingList.stream().map(rating -> {
			
			//call hotel service using rest template
			/*
			 * ResponseEntity<Hotel> hotelObject = restTemplate
			 * .getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
			 * Hotel.class);
			 */
			
			//call hotel service using feign client
			rating.setHotel(callHotelServiceExternally.getHotelById(rating.getHotelId()));
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(collectedList);
		return user;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
