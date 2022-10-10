package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.OrderDetails;
import com.Incture.oms.dao.OrderDetailsDao;
import com.Incture.oms.dto.OrderDetailsDto;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	private OrderDetailsDao orderDetailRepository;

	@Override
	public List<OrderDetails> getOrderDetails() {
		return this.orderDetailRepository.getOrderDetails();
	}

	@Override
	public OrderDetails getOrderDetail(long id) {
		return this.orderDetailRepository.getOrderDetail(id);
	}

	@Override
	public void saveOrderDetails(OrderDetailsDto orderDetails) {
		this.orderDetailRepository.saveOrderDetails(orderDetails);
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails, long id) {
		this.orderDetailRepository.updateOrderDetails(orderDetails, id);
	}

	@Override
	public void deleteOrderDetails(long id) {
		this.orderDetailRepository.deleteOrderDetails(id);
	}
	
	
}
