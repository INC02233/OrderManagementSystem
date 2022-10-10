package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Supplier;
import com.Incture.oms.Models.User;
import com.Incture.oms.config.HibernateUtil;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao{

	
	
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public List<Supplier> getSuppliers() {
		String hql = "FROM Supplier";
		Query query = hibernateUtil.getSession().createQuery(hql);
		List results = query.list();
		return results;
	}

	@Override
	public Supplier getSupplier(String id) {
		String hql = "FROM Supplier s where s.supplierId = :supplierID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("supplierID", id);
		Supplier supplier = (Supplier)query.uniqueResult();
		return supplier;
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		hibernateUtil.getSession().save(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier, String id) {
		String hql = "UPDATE Supplier s " + 
					"SET " + 
					"s.address = :address" + " , " +
					"s.city = :city" + " , " +
					"s.companyName = :companyName" + " , " +
					"s.contactNumber = :contactNumber" + " , " +
					"s.country = :country" + " , " +
					"s.email = :email" + " , " +
					"s.first_name = :first_name" + " , " +
					"s.last_name = :last_name" + " , " +
					"s.state = :state " +
					"WHERE s.supplierId = :supplierID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("address", supplier.getAddress());
		query.setParameter("city", supplier.getCity());
		query.setParameter("companyName", supplier.getCompanyName());
		query.setParameter("contactNumber", supplier.getContactNumber());
		query.setParameter("country", supplier.getCountry());
		query.setParameter("email", supplier.getEmail());
		query.setParameter("first_name", supplier.getFirst_name());
		query.setParameter("last_name", supplier.getLast_name());
		query.setParameter("state", supplier.getState());
		query.setParameter("supplierID", id);
		
		query.executeUpdate();
		
	}

	@Override
	public void deleteSupplier(String id) {
		String hql = "DELETE FROM Supplier WHERE supplierId = :supplierID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("supplierID", id);
		query.executeUpdate();
	}

}
