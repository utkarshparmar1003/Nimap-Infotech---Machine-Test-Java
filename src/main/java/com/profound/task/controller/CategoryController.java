package com.profound.task.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.profound.task.entity.Category;
import com.profound.task.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Get All Categories
	@GetMapping
	public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {

		return categoryService.getAllCategories(PageRequest.of(page, size)).getContent();
	}

	// Get Category by Id
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	// Create Category
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	// Update Category by Id
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	// Delete Category by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		if (categoryService.deleteCategory(id)) {
			return ResponseEntity.ok("Category with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with ID " + id + " not found.");
		}
	}
}
