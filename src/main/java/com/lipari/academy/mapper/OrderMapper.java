package com.lipari.academy.mapper;


import org.mapstruct.Mapper;

import com.lipari.academy.entity.OrderEntity;
import com.lipari.academy.model.OrderDTO;

@Mapper(componentModel = "spring", uses = OrderEntryMapper.class)
public interface OrderMapper {
	
	OrderEntity dtoToEntity(OrderDTO dto);
	
	OrderDTO entityToDto(OrderEntity entity);
	
}
