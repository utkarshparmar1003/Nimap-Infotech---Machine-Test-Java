package com.profound.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.profound.task.entity.Product;
import com.profound.task.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {

		return productRepository.findAll(pageable);
	}

	@Override
	public Product getProductById(Long id) {

		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found for this Id"));
	}

	@Override
	public Product createProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product updateProductDetails) {

		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		product.setPname(updateProductDetails.getPname());
		product.setPrice(updateProductDetails.getPrice());
		product.setCategory(updateProductDetails.getCategory());
		return productRepository.save(product);
	}

	@Override
	public boolean deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;

	}

}
