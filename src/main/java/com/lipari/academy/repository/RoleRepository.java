package com.lipari.academy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lipari.academy.entity.ERole;
import com.lipari.academy.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

	public Optional<RoleEntity> findByName(ERole role);
}
