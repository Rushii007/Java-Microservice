/**
 * 
 */
package com.rushi.microservice.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushi.microservice.user.entities.User;

/**
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
