package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.Orders;
import com.Incture.oms.Service.OrderService;
import com.Incture.oms.dto.OrderDto;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	public List<Orders> getOrders() {
		return this.orderService.getOrders();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
	public Orders getOrder(@PathVariable String id) {
		return this.orderService.getOrder(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String saveOrder(@RequestBody OrderDto orders) {
		this.orderService.saveOrder(orders);
		return "Order data saved successfully.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/update")
	public String updateOrder(@RequestBody Orders orders, @PathVariable String id) {
		this.orderService.updateOrder(orders, id);
		return "Orders updated successfully.";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public String deleteOrder(@PathVariable String id) {
		this.orderService.deleteOrder(id);
		return "Order deleted successfully.";
	}
	
}
