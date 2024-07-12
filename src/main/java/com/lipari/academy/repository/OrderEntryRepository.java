package com.lipari.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lipari.academy.entity.OrderEntryEntity;

@Repository
public interface OrderEntryRepository extends JpaRepository<OrderEntryEntity, Integer> {

	
}
