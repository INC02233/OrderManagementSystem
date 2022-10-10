package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.OrderDetails;
import com.Incture.oms.dto.OrderDetailsDto;

public interface OrderDetailsService {

	public List<OrderDetails> getOrderDetails();
	public OrderDetails getOrderDetail(long id);
	public void saveOrderDetails(OrderDetailsDto orderDetails);
	public void updateOrderDetails(OrderDetails orderDetails, long id);
	public void deleteOrderDetails(long id);
}
