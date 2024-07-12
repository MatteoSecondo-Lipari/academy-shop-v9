package com.lipari.academy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lipari.academy.entity.OrderEntryEntity;
import com.lipari.academy.mapper.OrderEntryMapper;
import com.lipari.academy.model.OrderEntryDTO;
import com.lipari.academy.repository.OrderEntryRepository;
import com.lipari.academy.service.OrderEntryService;

@Service
public class OrderEntryServiceImpl implements OrderEntryService {
	
	@Autowired
	OrderEntryRepository entryRepository;
	
	@Autowired
	OrderEntryMapper orderEntryMapper;

	@Override
	public OrderEntryDTO newEntry(OrderEntryDTO e) {
		OrderEntryEntity oe = orderEntryMapper.dtoToEntity(e);
		oe = entryRepository.save(oe);
		return orderEntryMapper.entityToDto(oe);
	}

	@Override
	public OrderEntryDTO updateEntry(OrderEntryDTO e) {
		OrderEntryEntity oe = orderEntryMapper.dtoToEntity(e);
		oe = entryRepository.save(oe);
		return orderEntryMapper.entityToDto(oe);
	}

}
