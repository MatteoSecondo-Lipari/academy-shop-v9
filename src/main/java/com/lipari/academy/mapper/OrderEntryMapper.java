package com.lipari.academy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lipari.academy.entity.OrderEntryEntity;
import com.lipari.academy.model.OrderEntryDTO;

@Mapper(componentModel = "spring")
public interface OrderEntryMapper {
	
	OrderEntryEntity dtoToEntity(OrderEntryDTO dto);
	
	@Mapping(target = "order", ignore = true)
	OrderEntryDTO entityToDto(OrderEntryEntity entity);
	
}
