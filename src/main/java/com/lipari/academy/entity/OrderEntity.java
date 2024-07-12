package com.lipari.academy.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customerOrder")
public class OrderEntity {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private String id;

	@Getter
	@Setter
	@Column(nullable = false)	
	String recipient;
	
	@Getter
	@Setter
	@Column(nullable = false)	
	String address;

	@Getter
	@Setter
	@Column(nullable = false)	
	Date date;

	@Getter
	@Setter
	@Column(nullable = false)	
	float total;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable=false)
	private CustomerEntity customer;
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy="order", cascade = CascadeType.REMOVE)
	private List<OrderEntryEntity> orderEntries;

}
