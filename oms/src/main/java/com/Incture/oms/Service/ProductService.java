package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.Product;
import com.Incture.oms.dto.ProductDto;

public interface ProductService {

	public List<Product> getProducts();
	public Product getProduct(String id);
	public void saveProduct(ProductDto product);
	public void updateProduct(Product product, String id);
	public void deleteProduct(String id);
}
