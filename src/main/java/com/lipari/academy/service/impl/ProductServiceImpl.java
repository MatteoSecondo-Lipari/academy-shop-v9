package com.lipari.academy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lipari.academy.entity.OrderEntryEntity;
import com.lipari.academy.entity.ProductEntity;
import com.lipari.academy.entity.SupplyEntity;
import com.lipari.academy.mapper.ProductMapper;
import com.lipari.academy.model.ProductDTO;
import com.lipari.academy.model.ProductWithProfitDTO;
import com.lipari.academy.model.ProductWithQuantityDTO;
import com.lipari.academy.repository.ProductRepository;
import com.lipari.academy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;

	@Override
	public ProductDTO newProduct(ProductDTO p) {
		ProductEntity pe = productMapper.dtoToEntity(p);
		pe = productRepository.save(pe);
		return productMapper.entityToDto(pe);
	}

	@Override
	public ProductDTO updateProduct(ProductDTO p) {
		ProductEntity pe = productMapper.dtoToEntity(p);
		pe = productRepository.save(pe);
		return productMapper.entityToDto(pe);
	}

	@Override
	public boolean deleteProductById(String id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Transactional
	@Override
	public int deleteProductByName(String name) {
		return productRepository.deleteByName(name);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll()
				.stream().map(productMapper::entityToDto)
				.toList();
	}

	@Override
	public ProductDTO findProductById(String id) {
		Optional<ProductEntity> pe = productRepository.findById(id);
		if(pe.isPresent()) {
			return productMapper.entityToDto(pe.get());
		} else {
			return null;
		}
	}

	@Override
	public ProductDTO findProductByName(String name) {
		Optional<ProductEntity> pe = productRepository.findByName(name);
		if(pe.isPresent()) {
			return productMapper.entityToDto(pe.get());
		} else {
			return null;
		}
	}
	
	@Override
	public List<ProductDTO> getAllProductsByCategory(String category) {
		return productRepository.findByCategory(category)
				.stream().map(productMapper::entityToDto)
				.toList();
	}

	@Override
	public List<ProductDTO> getAllProductsByCategoryAndPrice(String category, float price) {
		return productRepository.findByCategoryAndPrice(category, price)
				.stream().map(productMapper::entityToDto)
				.toList();
	}

	@Override
	public List<ProductWithQuantityDTO> getAllProductsAvailability() {
		List<ProductWithQuantityDTO> productsAvailability = new ArrayList<ProductWithQuantityDTO>();
		List<ProductEntity> products = productRepository.findAll();
		 
		for (ProductEntity product : products) {
			int productQuantity = 0;
			List<SupplyEntity> productSupplies = product.getSupplies();
			
			for (SupplyEntity productSupply : productSupplies) {
				productQuantity += productSupply.getQuantity();
			}
			
			List<OrderEntryEntity> productEntries = product.getOrderEntry();
			
			for (OrderEntryEntity productEntry : productEntries) {
				productQuantity -= productEntry.getQuantity();
			}
			
			ProductWithQuantityDTO productAvailability = new ProductWithQuantityDTO(
					productMapper.entityToDto(product), productQuantity);
			
			productsAvailability.add(productAvailability);
		}
		
		return productsAvailability;
	}
	
	@Override
	public ProductWithQuantityDTO getProductAvailabilityById(String id) {
		ProductEntity p = productRepository.findById(id).orElse(null);
		int productQuantity = 0;
		
		for (SupplyEntity  productSupply : p.getSupplies()) {
			productQuantity += productSupply.getQuantity();
		}
		
		for (OrderEntryEntity  productEntry : p.getOrderEntry()) {
			productQuantity -= productEntry.getQuantity();
		}
		
		return new ProductWithQuantityDTO(
				productMapper.entityToDto(p), 
				productQuantity
		);
	}

	@Override
	public ProductWithQuantityDTO getMostOrderedProduct() {
		List <ProductEntity> products = productRepository.findAll();
		
		ProductWithQuantityDTO p = new ProductWithQuantityDTO();
		
		for (ProductEntity product : products) {
			List<OrderEntryEntity> productEntries = product.getOrderEntry();
			int productQuantity = 0;
			
			for (OrderEntryEntity productEntry : productEntries) {
				productQuantity += productEntry.getQuantity();
			}
			
			if(productQuantity > p.getQuantity()) {
				p.setProduct(productMapper.entityToDto(product));
				p.setQuantity(productQuantity);
			}
		}
		
		return p;
	}

	@Override
	public ProductWithProfitDTO getMostProfitableProduct() {
		Pageable pageable = PageRequest.of(0, 1);
		List<ProductWithProfitDTO> result = productRepository.getMostProfitable(pageable);
		
		if(result.isEmpty()) {
			return null;
		}
		
		return result.get(0);
		
	}

}
