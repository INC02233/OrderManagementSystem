package com.Incture.oms.Service;

import java.util.List;

import com.Incture.oms.Models.Category;

public interface CategoryService {

	public List<Category> getCategories();
	public Category getCategory(long id);
	public void saveCategory(Category category);
	public void updateCategory(Category category, long id);
	public void deleteCategory(long id);
}
