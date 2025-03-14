package com.profound.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.profound.task.entity.Category;
import com.profound.task.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// Get All Categories
	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	// Get Category By Id
	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category Not Found for this Id"));
	}

	// Create Category
	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	// Update Category
	@Override
	public Category updateCategory(Long id, Category updateCategoryDetails) {

		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		category.setCname(updateCategoryDetails.getCname());
		return categoryRepository.save(category);

	}

	// Delete Category
	@Override
	public boolean deleteCategory(Long id) {
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return true;
		}
		return false;

	}

}
