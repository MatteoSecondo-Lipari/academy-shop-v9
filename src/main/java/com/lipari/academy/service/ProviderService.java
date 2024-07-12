package com.lipari.academy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lipari.academy.model.ProviderDTO;

@Service
public interface ProviderService {
	
	public List<ProviderDTO> getAll(); 
	public ProviderDTO getById(long id);
	
	public ProviderDTO createOrUpdate(ProviderDTO p);
	
	public boolean deleteById(long id);
}
