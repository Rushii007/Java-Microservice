/**
 * 
 */
package com.rushi.microservice.user.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushi.microservice.user.entities.User;
import com.rushi.microservice.user.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

/**
 * 
 */
@RestController
@RequestMapping("/users")
public class UserController {

	public static final Logger log = LogManager.getLogger(UserController.class); 
	
	Integer count = 1;
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	} 
	
	@GetMapping("/{userId}")
	//if service is down then use below annotation
//	@CircuitBreaker(name = "userBreaker",fallbackMethod =  "userFallbackFun")

	//if service is slow then use below annotation
//	@Retry(name = "userRetryService",fallbackMethod =  "userFallbackFun")
	//if client try to hit same req for multiple time using below annotation we can prevent this
	@RateLimiter(name = "userLimiterService",fallbackMethod =  "userFallbackFun")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		log.info("Retry count: {}",count);
		count++;
		User user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	public ResponseEntity<User> userFallbackFun(String userId, Exception e) {
		log.error("Fallback is executed because service is down: {}", e.getMessage());
		e.printStackTrace();
		
		User user = User.builder().name("Temp Name")
				.email("temp@gmail.com")
				.about("This method is calling because some service is down")
				.userId("123456789")
				.build();
		
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = userService.getAllUsers();
		return ResponseEntity.ok(user);
	} 
	
	
}
