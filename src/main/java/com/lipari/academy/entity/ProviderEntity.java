package com.lipari.academy.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "provider")
public class ProviderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
	private List<SupplyEntity> supplies;
	
	
}
