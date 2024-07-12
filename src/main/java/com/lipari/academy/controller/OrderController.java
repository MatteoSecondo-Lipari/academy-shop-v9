package com.lipari.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lipari.academy.model.OrderDTO;
import com.lipari.academy.service.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	//salva e ritorna un ordine con il campo customer e i campi products 
	//con valori nulli, non riempie la tabella entries
	@PostMapping("save/v1")
	public OrderDTO newOrder_v1(@RequestBody OrderDTO o) {
		return orderService.newOrder_v1(o);
	}
	
	//salva e ritorna un ordine con tutti i campi riempiti, riempie la tabella entries
	@PostMapping("save/v2")
	public OrderDTO newOrder_v2(@RequestBody OrderDTO o) {
		return orderService.newOrder_v2(o);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping("update")
	public OrderDTO updateOrder(@RequestBody OrderDTO o) {
		return orderService.updateOrder(o);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("delete/{id}")
	public boolean deleteOrder(@PathVariable String id) {
		return orderService.deleteOrderById(id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("all")
	public List<OrderDTO> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("{customerId}/all")
	public List<OrderDTO> getOrderByCustomerId(@PathVariable long customerId) {
		return orderService.getAllOrdersByCustomerId(customerId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("{id}")
	public OrderDTO getOrderById(@PathVariable String id) {
		return orderService.findOrderById(id);
	}
	
}

