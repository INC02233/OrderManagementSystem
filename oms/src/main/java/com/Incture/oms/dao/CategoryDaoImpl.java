package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	public SessionFactory factory;
	
	@Override
	public List<Category> getCategories() {
		Session session  = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM Category";
			Query query = session.createQuery(hql);
			List results = query.list();
			tx.commit();
			return results;
		} catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Category getCategory(long id) {
		Session session  = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM Category WHERE categoryId = :categoryID";
			Query query = session.createQuery(hql);
			query.setParameter("categoryID", id);
			Category category = (Category)query.uniqueResult();
			tx.commit();
			return category;
			
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
	public void saveCategory(Category category) {
		Session session  = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(category);
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
	public void updateCategory(Category category, long id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			
			String hql = "UPDATE Category c "+
						 "SET "+
						 "c.categoryDescription = :categoryDescription"+" , "+
						 "c.categoryName = :categoryName "+
						 "WHERE c.categoryId = :categoryId"
						 ;
			Query query = session.createQuery(hql);
			query.setParameter("categoryDescription",category.getCategoryDescription());
			query.setParameter("categoryName", category.getCategoryName());
			query.setParameter("categoryId", id);
			
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
	public void deleteCategory(long id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "DELETE Category WHERE categoryId = :categoryID";
			Query query = session.createQuery(hql);
			query.setParameter("categoryID", id);
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

	
	

}
