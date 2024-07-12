package com.lipari.academy.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	String recipient;
	
	@Getter
	@Setter
	String address;

	@Getter
	@Setter
	Date date;

	@Getter
	@Setter
	float total;

	@Getter
	@Setter
	private CustomerDTO customer;
	
	@Getter
	@Setter
	private List<OrderEntryDTO> orderEntries;

}
