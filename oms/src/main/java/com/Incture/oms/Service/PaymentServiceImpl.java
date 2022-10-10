package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.Payment;
import com.Incture.oms.dao.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDao paymentRepository;

	@Override
	public List<Payment> getPayments() {
		return this.paymentRepository.getPayments();
	}

	@Override
	public Payment getPayment(long id) {
		return this.paymentRepository.getPayment(id);
	}

	@Override
	public void savePayment(Payment payment) {
		this.paymentRepository.savePayment(payment);
	}

//	@Override
//	public void updatePayment(Payment payment, long id) {
//		
//	}

	@Override
	public void deletePayment(long id) {
		this.paymentRepository.deletePayment(id);
	}
	
}
