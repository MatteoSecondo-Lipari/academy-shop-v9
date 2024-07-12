package com.lipari.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lipari.academy.model.ProductDTO;
import com.lipari.academy.model.ProductWithProfitDTO;
import com.lipari.academy.model.ProductWithQuantityDTO;
import com.lipari.academy.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/product/save")
	public ProductDTO newProduct(@RequestBody ProductDTO p) {
		return productService.newProduct(p);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping("/product/update")
	public ProductDTO updateProduct(@RequestBody ProductDTO p) {
		return productService.updateProduct(p);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/product/delete/{id}")
	public boolean deleteProduct(@PathVariable String id) {
		return productService.deleteProductById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/product/delete/name/{name}")
	public int deleteProductByName(@PathVariable String name) {
		return productService.deleteProductByName(name);
	}
	
	@GetMapping("/product/all")
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ProductDTO getProductById(@PathVariable String id) {
		return productService.findProductById(id);
	}
	
	@GetMapping("/product/name/{name}")
	public ProductDTO getProductByName(@PathVariable String name) {
		return productService.findProductByName(name);
	}
	
	@GetMapping("/product/category/{category}")
	public List<ProductDTO> getProductsByCategory(@PathVariable String category) {
		return productService.getAllProductsByCategory(category);
	}
	
	@GetMapping("/product/category/{category}/{price}")
	public List<ProductDTO> getProductsByCategory(@PathVariable String category, @PathVariable float price) {
		return productService.getAllProductsByCategoryAndPrice(category, price);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/product/availabilities")
	public List<ProductWithQuantityDTO> getAllProductsAvailability() {
		return productService.getAllProductsAvailability();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/product/availabilities/{id}")
	public ProductWithQuantityDTO getAllProductsAvailabilityById(@PathVariable String id) {
		return productService.getProductAvailabilityById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/product/most-ordered")
	public ProductWithQuantityDTO getMostOrderedProduct() {
		return productService.getMostOrderedProduct();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/product/most-profitable")
	public ProductWithProfitDTO getMostProfitableProduct() {
		return productService.getMostProfitableProduct();
	}
	
	
	

}
