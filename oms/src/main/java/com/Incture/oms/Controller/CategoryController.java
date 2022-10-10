package com.Incture.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Incture.oms.Models.Category;
import com.Incture.oms.Service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService; 
	
	@RequestMapping(method = RequestMethod.GET, value = "/categories")
	public List<Category> getCategories() {
		return this.categoryService.getCategories();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categories/{id}")
	public Category getCategory(@PathVariable long id) {
		return this.categoryService.getCategory(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String saveCategory(@RequestBody Category category) {
		this.categoryService.saveCategory(category);
		return "Category added successfully.";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/update")
	public String updateCategory(@RequestBody Category category, @PathVariable long id ) {
		this.categoryService.updateCategory(category, id);
		return "Category updated successfully.";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/delete")
	public String deleteCategory(@PathVariable long id) {
		this.categoryService.deleteCategory(id);
		return "Category deleted successfully.";
	}
	
	
}
