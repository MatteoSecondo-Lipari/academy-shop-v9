package com.lipari.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lipari.academy.entity.SupplyEntity;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
	
}
