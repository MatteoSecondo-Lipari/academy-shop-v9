package com.lipari.academy.mapper;

import org.mapstruct.Mapper;

import com.lipari.academy.entity.ProductEntity;
import com.lipari.academy.model.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	ProductEntity dtoToEntity(ProductDTO dto);
	
	ProductDTO entityToDto(ProductEntity entity);
	
}
