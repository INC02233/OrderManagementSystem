package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.Orders;
import com.Incture.oms.dao.OrderDao;
import com.Incture.oms.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderRepository;

	@Override
	public List<Orders> getOrders() {
		return this.orderRepository.getOrders();
	}

	@Override
	public Orders getOrder(String id) {
		return this.orderRepository.getOrder(id);
	}

	@Override
	public void saveOrder(OrderDto orders) {
		this.orderRepository.saveOrder(orders);
	}

	@Override
	public void updateOrder(Orders orders, String id) {
		this.orderRepository.updateOrder(orders, id);
	}

	@Override
	public void deleteOrder(String id) {
		this.orderRepository.deleteOrder(id);
	}
	
	
}
