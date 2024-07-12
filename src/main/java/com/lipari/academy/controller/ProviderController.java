package com.lipari.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lipari.academy.model.ProviderDTO;
import com.lipari.academy.service.ProviderService;


@RestController
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	ProviderService providerService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public ProviderDTO createOrUpdate(@RequestBody ProviderDTO p) {
		return providerService.createOrUpdate(p);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public List<ProviderDTO> getAll() {
		return providerService.getAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/get/{id}")
	public ProviderDTO getById(@PathVariable long id) {
		return providerService.getById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public boolean deleteById(@PathVariable long id) {
		return providerService.deleteById(id);
	}
	
	
	
}
