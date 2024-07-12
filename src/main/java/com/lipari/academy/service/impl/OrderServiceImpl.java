package com.lipari.academy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lipari.academy.entity.OrderEntity;
import com.lipari.academy.mapper.OrderMapper;
import com.lipari.academy.model.CustomerDTO;
import com.lipari.academy.model.OrderDTO;
import com.lipari.academy.model.OrderEntryDTO;
import com.lipari.academy.model.ProductDTO;
import com.lipari.academy.repository.OrderRepository;
import com.lipari.academy.service.CustomerService;
import com.lipari.academy.service.OrderEntryService;
import com.lipari.academy.service.OrderService;
import com.lipari.academy.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderEntryService entryService;
	
	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public OrderDTO newOrder_v1(OrderDTO o) {
		OrderEntity oe = orderMapper.dtoToEntity(o);
		oe = orderRepository.save(oe);
		return orderMapper.entityToDto(oe);
	}
	
	@Override
	public OrderDTO newOrder_v2(OrderDTO o) {
		List<OrderEntryDTO> entries = new ArrayList<OrderEntryDTO>();
		
		//search customer by id
		long customerId = o.getCustomer().getId();
		CustomerDTO cDTO = this.customerService.getCustomerById(customerId);

		if(cDTO == null) {
			return null;
		}

		o.setCustomer(cDTO);
		
		//search products and calculate total
		float total = 0;

		for(OrderEntryDTO e : o.getOrderEntries()) {
			String productId = e.getProduct().getId();
			ProductDTO pdto = productService.findProductById(productId);

			e.setProduct(pdto);
			total += e.getQuantity() * pdto.getPrice();

			entries.add(e);
		}

		o.setTotal(total);

		if(!isOrderValid(o)) {
			return null; //qualche prodotto non ha abbastanza disponibilità in magazzino
		}
		
		o = newOrder_v1(o);
		
		//create entries
		for(OrderEntryDTO e : entries) {
			e.setOrder(o);
			entryService.newEntry(e);
		}
		
		return o;
	}

	@Override
	public OrderDTO updateOrder(OrderDTO o) {
		OrderEntity oe = orderMapper.dtoToEntity(o);
		oe = orderRepository.save(oe);
		return orderMapper.entityToDto(oe);
	}

	@Override
	public boolean deleteOrderById(String id) {
		if(orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		return orderRepository.findAll()
				.stream().map(orderMapper::entityToDto)
				.toList();
	}

	@Override
	public List<OrderDTO> getAllOrdersByCustomerId(long customerId) {
		return orderRepository.getOrdersByCustomerId(customerId)
				.stream().map(orderMapper::entityToDto).toList();
	}

	@Override
	public OrderDTO findOrderById(String id) {
		Optional<OrderEntity> oe = orderRepository.findById(id);
		if(oe.isPresent())
			return orderMapper.entityToDto(oe.get());
		return null;
	}
	
	public boolean isOrderValid(OrderDTO o) {
		for (OrderEntryDTO orderEntry : o.getOrderEntries()) {
			String productId = orderEntry.getProduct().getId();
			
			if(productService.getProductAvailabilityById(productId).getQuantity() - orderEntry.getQuantity() < 0) {
				return false;
			}
		}
		
		return true;
	}

}
