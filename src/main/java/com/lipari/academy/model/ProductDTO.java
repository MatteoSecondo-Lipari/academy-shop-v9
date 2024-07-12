package com.lipari.academy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private float price;
	
	@Getter
	@Setter
	private String category;
	
}
