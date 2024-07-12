package com.lipari.academy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lipari.academy.entity.ProductEntity;
import com.lipari.academy.model.ProductWithProfitDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	
	public Optional<ProductEntity> findByName(String name);
	public List<ProductEntity> findByCategory(String category);
	public List<ProductEntity> findByCategoryAndPrice(String category, float price);
	
	public int deleteByName(String name);
	
	@Query("SELECT new com.lipari.academy.model.ProductWithProfitDTO(" +
				"new com.lipari.academy.model.ProductDTO(p.id, p.name, p.description, p.price, p.category), " +
				"(p.price - s.price)) " +
				"FROM ProductEntity p " +
				"JOIN OrderEntryEntity o ON o.product.id = p.id " +
				"JOIN SupplyEntity s ON s.product.id = p.id " +
				"WHERE o.product.id = s.product.id " +
	           	"ORDER BY (p.price - s.price) DESC")
	public List<ProductWithProfitDTO> getMostProfitable(Pageable pageable);
}
