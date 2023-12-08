/**
 * 
 */
package com.rushi.microservice.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "micro_hotels")
public class Hotel {

	@Id
	@Column(name = "hotel_id")
	private String hotelId;
	private String name;
	private String location;
	private String about;
	
}
