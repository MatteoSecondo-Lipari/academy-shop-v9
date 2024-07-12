package com.lipari.academy.service;

import java.util.List;

import com.lipari.academy.model.ProductDTO;
import com.lipari.academy.model.ProductWithProfitDTO;
import com.lipari.academy.model.ProductWithQuantityDTO;

public interface ProductService {

	public ProductDTO newProduct(ProductDTO p);
	
	public ProductDTO updateProduct(ProductDTO p);
	
	public boolean deleteProductById(String id);
	public int deleteProductByName(String name);
	
	public List<ProductDTO> getAllProducts();
	public ProductDTO findProductById(String id);
	public ProductDTO findProductByName(String name);
	public List<ProductDTO> getAllProductsByCategory(String category);
	public List<ProductDTO> getAllProductsByCategoryAndPrice(String category, float price);
	
	public List<ProductWithQuantityDTO> getAllProductsAvailability();
	public ProductWithQuantityDTO getProductAvailabilityById(String id);
	public ProductWithQuantityDTO getMostOrderedProduct();
	public ProductWithProfitDTO getMostProfitableProduct();
}
