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

import com.lipari.academy.model.SupplyDTO;
import com.lipari.academy.service.SupplyService;

@RestController
@RequestMapping("/supply")
public class SupplyController {
	
	@Autowired
	SupplyService supplyService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public SupplyDTO createOrUpdate(@RequestBody SupplyDTO s) {
		return supplyService.createOrUpdate(s);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public List<SupplyDTO> getAll() {
		return supplyService.getAll();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@Secured({"ADMIN"})
	@GetMapping("/get/{id}")
	public SupplyDTO getById(@PathVariable long id) {
		return supplyService.getById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("delete/{id}")
	public boolean deleteById(@PathVariable long id) {
		return supplyService.deleteById(id);
	}
	
}
