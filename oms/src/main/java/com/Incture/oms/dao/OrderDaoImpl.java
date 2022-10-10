package com.Incture.oms.dao;

import java.util.List;


import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Orders;
import com.Incture.oms.config.HibernateUtil;
import com.Incture.oms.dto.OrderDto;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao{

	
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private UserDao userRepository;
	
	@Autowired
	private PaymentDao paymentRepository;
	
	@Autowired
	private ProductDao productRepository;
	
	@Autowired
	private ShipperDao shipperRepository;
	
	@Override
	public List<Orders> getOrders() {
		String hql = "FROM Orders";
		Query query = hibernateUtil.getSession().createQuery(hql);
		List results= query.list();
		return results;
	}

	@Override
	public Orders getOrder(String id) {
		String hql = "FROM Orders o WHERE o.orderId = :orderID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("orderID", id);
		Orders showOrders = (Orders)query.uniqueResult();
		return showOrders;
	}

	@Override
	public void saveOrder(OrderDto orders) {
		
		Orders newOrders = new Orders();
	
		newOrders.setPaid(orders.isPaid());
		newOrders.setStatus(orders.getStatus());
		
		newOrders.setOrderedBy(userRepository.getUser(orders.getUserID()));
		newOrders.setPaymentID_fk(paymentRepository.getPayment(orders.getPaymentID()));
		newOrders.setProductID(productRepository.getProduct(orders.getProductID()));
		newOrders.setShipperID_fk(shipperRepository.getShipper(orders.getShipperID()));
		
		hibernateUtil.getSession().save(newOrders);
		
		
	}

	@Override
	public void updateOrder(Orders orders, String id) {
		String hql = "UPDATE Orders o " + 
					"SET "+
					"o.OrderDate = :orderDate"+" , "+
					"o.paid = :paid"+" , "+
					"o.PaymentDate = :paymentDate"+" , "+
					"o.ShippedDate = :shippedDate"+" , "+
					"o.status = :status "+
					"WHERE o.orderId = :orderID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("orderDate", orders.getOrderedAt());
		query.setParameter("paid", orders.isPaid());
		query.setParameter("paymentDate", orders.getPaymentDate());
		query.setParameter("shippedDate", orders.getShippedDate());
		query.setParameter("status", orders.getStatus());
		query.setParameter("orderID", id);
		
		query.executeUpdate();
	}

	@Override
	public void deleteOrder(String id) {
		String hql = "DELETE FROM Orders WHERE orderId = :orderID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("orderID", id);
		query.executeUpdate();
	}

}
