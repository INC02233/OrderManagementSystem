package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.Product;
import com.Incture.oms.Service.ProductService;
import com.Incture.oms.dto.ProductDto;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> getProducts() {
		return this.productService.getProducts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
	public Product getProduct(@PathVariable String id) {
		return this.productService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String saveProduct(@RequestBody ProductDto product) {
		this.productService.saveProduct(product);
		return "Product created successfully.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/udpate")
	public String updateProduct(@RequestBody Product product, @PathVariable String id) {
		this.productService.updateProduct(product, id);
		return "Product updated successfully.";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public String deleteProduct(@PathVariable String id) {
		this.productService.deleteProduct(id);
		return "Product deleted successfully.";
	}
	
}
