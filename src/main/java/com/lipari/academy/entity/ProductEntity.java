package com.lipari.academy.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;

	@Getter
	@Setter
	@Column(unique = true, nullable = false)
	private String name;
	
	@Getter
	@Setter
	@Column
	private String description;
	
	@Getter
	@Setter
	@Column
	private float price;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private String category;
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderEntryEntity> orderEntry;
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<SupplyEntity> supplies;
	
}
