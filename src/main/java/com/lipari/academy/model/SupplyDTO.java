package com.lipari.academy.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDTO {

	private long id;
	
	private ProductDTO product;
	
	private ProviderDTO provider;
	
	private int quantity;
	
	private LocalDate localDate;
	
	private float price;
}
