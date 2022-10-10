package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.Payment;
import com.Incture.oms.Service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/payments")
	public List<Payment> getPayments() {
		return this.paymentService.getPayments();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/payments/{id}")
	public Payment getPayment(@PathVariable long id) {
		return this.paymentService.getPayment(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String savePayment(@RequestBody Payment payment) {
		this.paymentService.savePayment(payment);
		return "Payment made successfully.";
	}
	
//	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/update")
//	public String updatePayment(@RequestBody Payment payment, @PathVariable long id) {
//		this.paymentService.updatePayment(payment, id);
//		return "Payment updated successfully.";
//	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public String deletePayment(@PathVariable long id) {
		this.paymentService.deletePayment(id);
		return "Payment deleted Successfully";
	}
}
