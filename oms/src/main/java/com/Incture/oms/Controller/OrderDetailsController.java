package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.OrderDetails;
import com.Incture.oms.Service.OrderDetailsService;
import com.Incture.oms.dto.OrderDetailsDto;

@RestController
@RequestMapping("/api/v1/orderDetails")
public class OrderDetailsController {
	
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	public List<OrderDetails> getOrderDetails() {
		return this.orderDetailsService.getOrderDetails();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
	public OrderDetails getOrderDetail(@PathVariable long id) {
		return this.orderDetailsService.getOrderDetail(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String saveOrderDetails(@RequestBody OrderDetailsDto orderDetails) {
		this.orderDetailsService.saveOrderDetails(orderDetails);
		return "OrderDetails data added successfully.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/udpate")
	public String updateOrderDetails(@RequestBody OrderDetails orderDetails, @PathVariable long id) {
		this.orderDetailsService.updateOrderDetails(orderDetails, id);
		return "OrderDetails data updated successfully.";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/delete")
	public String deleteOrderDetails(@PathVariable long id) {
		this.orderDetailsService.deleteOrderDetails(id);
		return "OrderDetails data deleted successfully.";
	}
}
