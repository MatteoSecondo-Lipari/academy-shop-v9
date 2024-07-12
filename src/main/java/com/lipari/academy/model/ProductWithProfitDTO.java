package com.lipari.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithProfitDTO {

	private ProductDTO product;
	
	private float profit;
}
