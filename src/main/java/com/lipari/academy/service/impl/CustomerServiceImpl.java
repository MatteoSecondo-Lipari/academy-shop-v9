package com.lipari.academy.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lipari.academy.entity.CustomerEntity;
import com.lipari.academy.mapper.CustomerMapper;
import com.lipari.academy.model.CustomerDTO;
import com.lipari.academy.repository.CustomerRepository;
import com.lipari.academy.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerMapper customerMapper;

	@Override
	public CustomerDTO newCustomer(CustomerDTO c) {
		CustomerEntity ce = customerMapper.dtoToEntity(c); 
		ce = customerRepository.save(ce);
		return customerMapper.entityToDto(ce);
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO c) {
		CustomerEntity ce = customerMapper.dtoToEntity(c); 
		ce = customerRepository.save(ce);
		return customerMapper.entityToDto(ce);
	}

	@Override
	public boolean deleteCustomerById(long id) {
		if(customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll()
				.stream().map(customerMapper::entityToDto)
				.toList();
	}

	@Override
	public CustomerDTO getCustomerById(long id) {
		Optional<CustomerEntity> ce = customerRepository.findById(id);
		if(ce.isPresent())
			return customerMapper.entityToDto(ce.get());
		return null;
	}

	@Override
	public List<CustomerDTO> getCustomerByName(String nameSubstring) {
		return customerRepository.findByNameContains(nameSubstring)
				.stream().map(customerMapper::entityToDto)
				.toList();
	}

	@Override
	public List<CustomerDTO> getCustomerByAddress(String addressSubstring) {
		return customerRepository.findByAddressContains(addressSubstring)
				.stream().map(customerMapper::entityToDto)
				.toList();
	}

	@Override
	public List<CustomerDTO> getCustomerByBirthDate(Date birthDate) {
		return customerRepository.findByBirthDate(birthDate)
				.stream().map(customerMapper::entityToDto)
				.toList();
	}
	
}
