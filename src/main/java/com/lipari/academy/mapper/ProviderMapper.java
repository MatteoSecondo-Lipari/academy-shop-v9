package com.lipari.academy.mapper;

import org.mapstruct.Mapper;

import com.lipari.academy.entity.ProviderEntity;
import com.lipari.academy.model.ProviderDTO;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
	
	ProviderEntity dtoToEntity(ProviderDTO dto);
	
	ProviderDTO entityToDto(ProviderEntity entity);
}
