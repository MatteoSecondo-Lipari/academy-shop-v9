package com.lipari.academy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {

	private long id;
	
	private String name;
	
	private String address;
	
}
