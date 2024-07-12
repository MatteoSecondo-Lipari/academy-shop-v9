package com.lipari.academy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lipari.academy.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public Optional<UserEntity> findByUsername(String username);
	
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
}
