package com.Incture.oms.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Incture.oms.Models.Product;
import com.Incture.oms.config.HibernateUtil;
import com.Incture.oms.dto.ProductDto;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private CategoryDao categoryRepository;
	
	@Autowired
	private SupplierDao supplierRepository;
	
	@Override
	public List<Product> getProducts() {
		String hql = "FROM Product";
		Query query = hibernateUtil.getSession().createQuery(hql);
		List results= query.list();
		return results;
	}

	@Override
	public Product getProduct(String id) {
		String hql = "FROM Product WHERE productId = :productID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("productID", id);
		Product product = (Product)query.uniqueResult();
		return product;
	}

	@Override
	public void saveProduct(ProductDto product) {
		
		Product newProduct = new Product();
		
		newProduct.setAvailableSize(product.getAvailableSize());
		newProduct.setPrice(product.getPrice());
		newProduct.setProductAvailable(product.isProductAvailable());
		newProduct.setProductDescription(product.getProductDescription());
		newProduct.setProductName(product.getProductName());
		newProduct.setRating(product.getRating());
		
		newProduct.setProductCategory(categoryRepository.getCategory(product.getCategoryID()));
		newProduct.setSupplierInfo(supplierRepository.getSupplier(product.getSupplierID()));
		
		hibernateUtil.getSession().save(newProduct);
		
	}

	@Override
	public void udpateProduct(Product product, String id) {
		String hql = "UDPATE Product p " +
					"SET " +
					"p.availabeSize = :availabeSize" + " , " +
					"p.price = :price" + " , " +
					"p.productAvailable = :productAvailable" + " , " +
					"p.productDescription = :productDescription" + " , " +
					"p.productName = :productName" + " , " +
					"p.rating = :rating" + 
					"WHERE p.productId = :productID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("availabeSize", product.getAvailableSize() );
		query.setParameter("price", product.getPrice() );
		query.setParameter("productAvailable", product.isProductAvailable());
		query.setParameter("productDescription", product.getProductDescription() );
		query.setParameter("productName", product.getProductName());
		query.setParameter("rating", product.getRating());
		query.setParameter("productID", id);
		
		query.executeUpdate();
	
	}

	@Override
	public void deleteProduct(String id) {
		String hql = "DELETE FROM Product WHERE productId = :productID";
		Query query = hibernateUtil.getSession().createQuery(hql);
		query.setParameter("productID", id);
		query.executeUpdate();
	}

}
