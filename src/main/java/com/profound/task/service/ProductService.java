package com.profound.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.profound.task.entity.Product;

public interface ProductService {

	public Page<Product> getAllProducts(Pageable pageable);

	public Product getProductById(Long id);

	public Product createProduct(Product product);

	public Product updateProduct(Long id, Product updateProductDetails);

	public boolean deleteProduct(Long id);
}
