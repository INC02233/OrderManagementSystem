package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.Product;
import com.Incture.oms.dto.ProductDto;

public interface ProductDao {

	public List<Product> getProducts();
	public Product getProduct(String id);
	public void saveProduct(ProductDto product);
	public void udpateProduct(Product product, String id);
	public void deleteProduct(String id);
}
