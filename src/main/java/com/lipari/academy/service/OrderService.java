package com.lipari.academy.service;

import java.util.List;

import com.lipari.academy.model.OrderDTO;

public interface OrderService {

	public OrderDTO newOrder_v1(OrderDTO o);
	public OrderDTO newOrder_v2(OrderDTO o);
	
	public OrderDTO updateOrder(OrderDTO o);
	
	public boolean deleteOrderById(String id);
	
	public List<OrderDTO> getAllOrders();
	public List<OrderDTO> getAllOrdersByCustomerId(long customerId);
	public OrderDTO findOrderById(String id);
}
