/**
 * 
 */
package com.rushi.microservice.user.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Entity
@Table(name = "micro_users")
public class User {

	@Id
	@Column(name = "user_id")
	private String userId;
	
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient
	private List<Rating> ratings = new LinkedList<>();
}
