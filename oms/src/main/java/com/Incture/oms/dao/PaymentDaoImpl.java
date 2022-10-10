package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Payment;
import com.Incture.oms.config.HibernateUtil;

@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao {

	
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public List<Payment> getPayments() {
		String hql = "FROM Payment";
		Query query = hibernateUtil.getSession().createQuery(hql);
		List results = query.list();
		return results;
	}

	@Override
	public Payment getPayment(long id) {
		String hql = "FROM Payment WHERE paymentId = :paymentID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("paymentID", id);
		Payment payment = (Payment)query.uniqueResult();
		return payment;
	}

	@Override
	public void savePayment(Payment payment) {
		hibernateUtil.getSession().save(payment);
	}

//	@Override
//	public void updatePayment(Payment payment, long id) {
//		String hql = "";
//		Query query = hibernateUtil.getSession().createQuery(hql);
//	}

	@Override
	public void deletePayment(long id) {
		String hql = "DELETE FROM Payment WHERE paymentId = :paymentID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("paymentID", id);
		query.executeUpdate();
	}

}
