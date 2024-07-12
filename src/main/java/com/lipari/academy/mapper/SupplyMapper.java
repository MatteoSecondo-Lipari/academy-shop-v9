package com.lipari.academy.mapper;


import org.mapstruct.Mapper;

import com.lipari.academy.entity.SupplyEntity;
import com.lipari.academy.model.SupplyDTO;

@Mapper(componentModel = "spring")
public interface SupplyMapper {
	
	SupplyEntity dtoToEntity(SupplyDTO dto);
	
	SupplyDTO entityToDto(SupplyEntity entity);
}
