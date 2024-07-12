package com.lipari.academy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lipari.academy.model.CustomerDTO;
import com.lipari.academy.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/customer/new")
	public CustomerDTO newCustomer(@RequestBody CustomerDTO c) {
		if(c.getName().length() > 0 && c.getAddress().length() > 0)
			return customerService.newCustomer(c);
		else {
			return null;
		}
	}
	
	@PutMapping("/customer/update")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO c) {
		return customerService.updateCustomer(c);
	}
	
	@DeleteMapping("/customer/delete/{id}")
	public boolean deleteCustomerById(@PathVariable long id) {
		return customerService.deleteCustomerById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("customer/get/all")
	public List<CustomerDTO> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("customer/get/id/{id}")
	public CustomerDTO getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("customer/get/name/{nameSubstring}")
	public List<CustomerDTO> getCustomerByName(@PathVariable String nameSubstring) {
		return customerService.getCustomerByName(nameSubstring);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("customer/get/address/{addressSubstring}")
	public List<CustomerDTO> getCustomerByAddres(@PathVariable String addressSubstring) {
		return customerService.getCustomerByAddress(addressSubstring);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("customer/get/birthDate/{birthDate}")
	public List<CustomerDTO> getCustomerByBirthDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date birthDate) {
		return customerService.getCustomerByBirthDate(birthDate);
	}
	
}
