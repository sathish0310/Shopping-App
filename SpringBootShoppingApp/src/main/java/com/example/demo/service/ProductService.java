package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFound;

public interface ProductService {
	public abstract String addProduct(Product product);

	public abstract Product updateProduct(Product product);

	public abstract String deleteProduct(int productId);

	public abstract Product getProductById(int productId) throws ProductNotFound;

	public abstract List<Product> getAllProducts();

	public abstract List<Product> getAllProductsBetween(int initialPrice, int finalPrice);
	
	public abstract List<Product> findByProductCategory(String category);
	
	public List<Product> findByProductCategoryAndProductPriceLessThan(String category,int productPrice);

}
