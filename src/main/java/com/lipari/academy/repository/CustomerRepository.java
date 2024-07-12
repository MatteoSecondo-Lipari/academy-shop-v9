package com.lipari.academy.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lipari.academy.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	public List<CustomerEntity> findByNameContains(String nameSubstring);
	public List<CustomerEntity> findByAddressContains(String addressSubstring);
	public List<CustomerEntity> findByBirthDate(Date birthDate);
}
