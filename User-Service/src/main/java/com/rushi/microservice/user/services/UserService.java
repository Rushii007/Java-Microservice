/**
 * 
 */
package com.rushi.microservice.user.services;

import java.util.List;

import com.rushi.microservice.user.entities.User;

/**
 * 
 */
public interface UserService {

	public User saveUser(User user);
	public List<User> getAllUsers();
	public User getUserById(String userId);
	public void deleteUser(String userId);
	public User updateUser(User user);
	
}
