package com.lipari.academy.service;

import com.lipari.academy.model.OrderEntryDTO;

public interface OrderEntryService {

	public OrderEntryDTO newEntry(OrderEntryDTO e);
	public OrderEntryDTO updateEntry(OrderEntryDTO e);
}
