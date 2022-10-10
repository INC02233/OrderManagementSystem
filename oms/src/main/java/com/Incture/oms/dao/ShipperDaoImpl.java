package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Shippers;
import com.Incture.oms.config.HibernateUtil;

@Repository
@Transactional
public class ShipperDaoImpl implements ShipperDao{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public List<Shippers> getShippers() {
		String hql = "FROM Shippers";
		Query query = hibernateUtil.getSession().createQuery(hql);
		List results = query.list();
		return results;
	}

	@Override
	public Shippers getShipper(long id) {
		String hql = "FROM Shippers WHERE shipperId = :shipperID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("shipperID", id);
		Shippers shippers = (Shippers)query.uniqueResult();
		return shippers;
	}

	@Override
	public void saveShipper(Shippers shippers) {
		hibernateUtil.getSession().save(shippers);
		
	}

	@Override
	public void updateShipper(Shippers shippers, long id) {
		String hql = "UPDATE Shippers s "+
					"SET "+
					"s.companyName = :companyName "+" , "+
					"s.phone = :phone "+
					"WHERE s.shipperId = :shipperID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("shipperID", id);
		query.setParameter("companyName", shippers.getCompanyName() );
		query.setParameter("phone", shippers.getPhone() );		
		
		query.executeUpdate();
	}

	@Override
	public void deleteShipper(long id) {
		String hql = "DELETE FROM Shippers WHERE shipperId = :shipperID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("shipperID", id);
		
		query.executeUpdate();
		
	}

}
