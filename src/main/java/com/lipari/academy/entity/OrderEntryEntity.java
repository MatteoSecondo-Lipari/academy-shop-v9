package com.lipari.academy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "orderEntry")
public class OrderEntryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductEntity product;
	
	@Column(nullable = false)
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private OrderEntity order;
}
