package com.lipari.academy.mapper;

import org.mapstruct.Mapper;

import com.lipari.academy.entity.CustomerEntity;
import com.lipari.academy.model.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
		
	CustomerEntity dtoToEntity(CustomerDTO dto);

	CustomerDTO entityToDto(CustomerEntity entity);
	
}
