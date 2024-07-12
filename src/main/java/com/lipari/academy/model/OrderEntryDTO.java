package com.lipari.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntryDTO {

	private long id;
	
	private ProductDTO product;
	
	private int quantity;
	
	private OrderDTO order;
}
