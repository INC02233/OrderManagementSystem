package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.Payment;

public interface PaymentDao {

	public List<Payment> getPayments();
	public Payment getPayment(long id);
	public void savePayment(Payment payment);
//	public void updatePayment(Payment payment, long id);
	public void deletePayment(long id);
}
