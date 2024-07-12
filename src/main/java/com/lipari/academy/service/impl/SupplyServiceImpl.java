package com.lipari.academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lipari.academy.entity.SupplyEntity;
import com.lipari.academy.mapper.SupplyMapper;
import com.lipari.academy.model.SupplyDTO;
import com.lipari.academy.repository.SupplyRepository;
import com.lipari.academy.service.SupplyService;

@Service
public class SupplyServiceImpl implements SupplyService {
	
	@Autowired
	SupplyRepository supplyRepository;
	
	@Autowired
	SupplyMapper supplyMapper;

	@Override
	public SupplyDTO createOrUpdate(SupplyDTO s) {
		SupplyEntity se = supplyMapper.dtoToEntity(s);
		return supplyMapper.entityToDto(supplyRepository.save(se));
	}

	@Override
	public List<SupplyDTO> getAll() {
		return supplyRepository.findAll().stream().map(supplyMapper::entityToDto).toList();
	}

	@Override
	public SupplyDTO getById(long id) {
		return supplyMapper.entityToDto(supplyRepository.findById(id).orElse(null));
	}

	@Override
	public boolean deleteById(long id) {
		if(supplyRepository.existsById(id)) {
			supplyRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
