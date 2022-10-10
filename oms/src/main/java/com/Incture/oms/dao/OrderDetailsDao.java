package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.OrderDetails;
import com.Incture.oms.dto.OrderDetailsDto;

public interface OrderDetailsDao {

	public List<OrderDetails> getOrderDetails();
	public OrderDetails getOrderDetail(long id);
	public void saveOrderDetails(OrderDetailsDto orderDetails);
	public void updateOrderDetails(OrderDetails orderDetails, long id);
	public void deleteOrderDetails(long id);
}
