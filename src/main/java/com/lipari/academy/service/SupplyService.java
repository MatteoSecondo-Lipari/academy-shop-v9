package com.lipari.academy.service;

import java.util.List;

import com.lipari.academy.model.SupplyDTO;

public interface SupplyService {

	public SupplyDTO createOrUpdate(SupplyDTO s);
	
	public List<SupplyDTO> getAll();
	public SupplyDTO getById(long id);
	
	public boolean deleteById(long id);
}
