package com.profound.task.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.profound.task.entity.Category;

public interface CategoryService {

	public Page<Category> getAllCategories(Pageable pageable);
	
	public Optional<Category> getCategoryById(Long id);
	
	public Category createCategory(Category category);
	
	public Category updateCategory(Long id, Category updateCategoryDetails);
	
	public boolean deleteCategory(Long id);
}
