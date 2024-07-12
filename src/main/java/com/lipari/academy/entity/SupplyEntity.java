package com.lipari.academy.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "supply")
public class SupplyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "provider_id", nullable = false)
	private ProviderEntity provider;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private LocalDate localDate;
	
	@Column(nullable = false)
	private float price;
}
