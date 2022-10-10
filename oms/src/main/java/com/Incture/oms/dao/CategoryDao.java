package com.Incture.oms.dao;

import java.util.List;

import com.Incture.oms.Models.Category;

public interface CategoryDao {

	public List<Category> getCategories();
	public Category getCategory(long id);
	public void saveCategory(Category category);
	public void updateCategory(Category category, long id);
	public void deleteCategory(long id);
}
