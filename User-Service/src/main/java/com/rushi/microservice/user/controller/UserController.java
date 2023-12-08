/**
 * 
 */
package com.rushi.microservice.user.controller;

import java.util.List;

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

/**
 * 
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	} 
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = userService.getAllUsers();
		return ResponseEntity.ok(user);
	} 
	
	
}
