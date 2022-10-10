package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.Product;
import com.Incture.oms.dao.ProductDao;
import com.Incture.oms.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productRepository;

	@Override
	public List<Product> getProducts() {
		return this.productRepository.getProducts();
	}

	@Override
	public Product getProduct(String id) {
		return this.productRepository.getProduct(id);
	}

	@Override
	public void saveProduct(ProductDto product) {
		this.productRepository.saveProduct(product);
	}

	@Override
	public void updateProduct(Product product, String id) {
		this.productRepository.udpateProduct(product, id);
	}

	@Override
	public void deleteProduct(String id) {
		this.productRepository.deleteProduct(id);
	}
	
	
	
}
