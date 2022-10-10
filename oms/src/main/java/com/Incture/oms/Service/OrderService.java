package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.Orders;
import com.Incture.oms.dto.OrderDto;

public interface OrderService {

	public List<Orders> getOrders();
	public Orders getOrder(String id);
	public void saveOrder(OrderDto orders);
	public void updateOrder(Orders orders, String id);
	public void deleteOrder(String id);
}
