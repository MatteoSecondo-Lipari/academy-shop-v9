package com.lipari.academy.service;

import java.util.Date;
import java.util.List;

import com.lipari.academy.model.CustomerDTO;

public interface CustomerService {

	public CustomerDTO newCustomer(CustomerDTO c);
	
	public CustomerDTO updateCustomer(CustomerDTO c);
	
	public boolean deleteCustomerById(long id);
	
	public List<CustomerDTO> getAllCustomers();
	public CustomerDTO getCustomerById(long id);
	public List<CustomerDTO> getCustomerByName(String nameSubstring);
	public List<CustomerDTO> getCustomerByAddress(String addressSubstring);
	public List<CustomerDTO> getCustomerByBirthDate(Date birthDate);
}
