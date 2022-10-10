package com.Incture.oms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Incture.oms.Models.Category;
import com.Incture.oms.dao.CategoryDaoImpl;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDaoImpl categoryRepository;

	@Override
	public List<Category> getCategories() {
		return this.categoryRepository.getCategories();
	}

	@Override
	public Category getCategory(long id) {
		return this.categoryRepository.getCategory(id);
	}

	@Override
	public void saveCategory(Category category) {
		this.categoryRepository.saveCategory(category);
		
	}

	@Override
	public void updateCategory(Category category, long id) {
		this.categoryRepository.updateCategory(category, id);
		
	}

	@Override
	public void deleteCategory(long id) {
		this.categoryRepository.deleteCategory(id);
		
	}
	
	
	
	
}
