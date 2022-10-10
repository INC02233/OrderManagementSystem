package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.Payment;

public interface PaymentService {

	public List<Payment> getPayments();
	public Payment getPayment(long id);
	public void savePayment(Payment payment);
//	public void updatePayment(Payment payment, long id);
	public void deletePayment(long id);
}
