package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.OrderDetails;
import com.Incture.oms.config.HibernateUtil;
import com.Incture.oms.dto.OrderDetailsDto;

@Repository
@Transactional
public class OrderDetailsDaoImpl implements OrderDetailsDao{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private OrderDao orderRepository;
	
	@Autowired
	private ProductDao productRepository;
	
	@Override
	public List<OrderDetails> getOrderDetails() {
		String hql = "FROM OrderDetails";
		Query query = hibernateUtil.getSession().createQuery(hql);
		List results = query.list();
		return results;
	}

	@Override
	public OrderDetails getOrderDetail(long id) {
		String hql = "FROM OrderDetails where orderDetailsId = :orderDetailsID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("orderDetailsID", id);
		OrderDetails orderDetails = (OrderDetails)query.uniqueResult();
		return orderDetails;
	}

	@Override
	public void saveOrderDetails(OrderDetailsDto orderDetails) {
		
		
		OrderDetails newOrderDetails = new OrderDetails();
		
		newOrderDetails.setColor(orderDetails.getColor());
		newOrderDetails.setDiscount(orderDetails.getDiscount());
		newOrderDetails.setPrice(orderDetails.getPrice());
		newOrderDetails.setQuantity(orderDetails.getQuantity());
		newOrderDetails.setSize(orderDetails.getSize());
		
		
		newOrderDetails.setOrderID_fk(orderRepository.getOrder(orderDetails.getOrderID()));
		newOrderDetails.setProductID_order(productRepository.getProduct(orderDetails.getProductID()));
		
		hibernateUtil.getSession().save(newOrderDetails);
		
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails, long id) {
		
	}

	@Override
	public void deleteOrderDetails(long id) {
		String hql = "DELETE FROM OrderDetails where orderDetailsId = :orderDetailsID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("orderDetailsID", id);
		query.executeUpdate();
	}

}
