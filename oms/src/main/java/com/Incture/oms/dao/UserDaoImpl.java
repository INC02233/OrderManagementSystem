package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	
	@Autowired
	private SessionFactory factory;
	
//	method to save user
	@Override
	public void saveUser(User user) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			
		} catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}


	@Override
	public List<User> getUsers() {
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		List results = query.list();
		return results;
	}


	@Override
	public User getUser(String id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM User WHERE userId = :userID";
			Query query = session.createQuery(hql);
			query.setParameter("userID", id);
			User user = (User)query.uniqueResult();
			tx.commit();
			return user;
			
		} catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}


	@Override
	public void updateUser(User user, String id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			
			String hql = "UPDATE User u "+
						 "SET "+
						 "u.address = :address"+" , "+
						 "u.city = :city"+" , "+
						 "u.country = :country"+" , "+
						 "u.email = :email"+" , "+
						 "u.first_name = :first_name"+" , "+
						 "u.houseNo = :houseNo"+" , "+
						 "u.last_name = :last_name"+" , "+
						 "u.password = :password"+" , "+
						 "u.phone = :phone"+" , "+
						 "u.state = :state "+
						 "WHERE u.userId = :userID"
						 ;
			Query query = session.createQuery(hql);
			query.setParameter("address", user.getAddress());
			query.setParameter("city", user.getCity());
			query.setParameter("country", user.getCountry());
			query.setParameter("email", user.getEmail());
			query.setParameter("first_name", user.getFirst_name());
			query.setParameter("houseNo", user.getHouseNo());
			query.setParameter("last_name", user.getLast_name());
			query.setParameter("password", user.getPassword());
			query.setParameter("phone", user.getPhone());
			query.setParameter("state", user.getState());
			query.setParameter("userID", id);
			
			tx = session.beginTransaction();
			query.executeUpdate();
			
			tx.commit();
			
		} catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
	}


	@Override
	public void deleteUser(String id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "DELETE User WHERE userId = :userID";
			Query query = session.createQuery(hql);
			query.setParameter("userID", id);
			query.executeUpdate();
			tx.commit();
			
		} catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	
		
	}
	
	
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		if(session == null) {
			session = factory.openSession();
		}
		return session;
	}
}
