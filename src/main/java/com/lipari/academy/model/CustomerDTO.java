package com.lipari.academy.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	
	private long id;
	
	private String name;
	
	private Date birthDate;
	
	private String address;
	
	private UserDTO	user;
	
}
