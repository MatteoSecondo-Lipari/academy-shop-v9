package com.lipari.academy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lipari.academy.entity.ProviderEntity;
import com.lipari.academy.mapper.ProviderMapper;
import com.lipari.academy.model.ProviderDTO;
import com.lipari.academy.repository.ProviderRepository;
import com.lipari.academy.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	ProviderMapper providerMapper;

	@Override
	public List<ProviderDTO> getAll() {
		return providerRepository.findAll().stream().map(providerMapper::entityToDto).toList();
	}

	@Override
	public ProviderDTO getById(long id) {
		Optional<ProviderEntity> op = providerRepository.findById(id);
		
		if(op.isEmpty()) {
			return null;
		}
		
		return providerMapper.entityToDto(op.get()); 
	}

	@Override
	public ProviderDTO createOrUpdate(ProviderDTO p) {
		ProviderEntity pe = providerMapper.dtoToEntity(p);
		return providerMapper.entityToDto(providerRepository.save(pe)) ;
	}

	@Override
	public boolean deleteById(long id) {
		if(providerRepository.existsById(id)) {
			providerRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
