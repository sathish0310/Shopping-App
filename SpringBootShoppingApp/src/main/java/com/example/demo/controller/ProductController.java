package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products") // http://localhost:8081/products
@AllArgsConstructor
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	ProductService service;

	// @RequestMapping(method=RequestMethod.POST,consumes="application/json",value="/save")
	// // Old method

	@PostMapping("/save") // http://localhost:8081/products/save
	public String saveProduct(@RequestBody Product product) {
		
		logger.info("Recieved request to save product: {}", product);
		String response = service.addProduct(product);
		logger.info("Product saved successfully with response: {}",response);
		return service.addProduct(product);
	}

	@PutMapping("/update") // http://localhost:8081/products/update
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:8081/products/delete/123
	public String deleteProduct(@PathVariable("id") int productId) {
		return service.deleteProduct(productId);
	}

	@GetMapping("/getProductById/{id}") // http://localhost:8081/products/getProductById/123
	public Product getProductBy(@PathVariable("id") int product) throws ProductNotFound {
		return service.getProductById(product);
	}

	@GetMapping("/getAll") // http://localhost:8081/products/getAll
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/getBetween/{price1}/{price2}") // http://localhost:8081/products/getBetween/10000/20000
	public List<Product> getAllBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}
	
	@GetMapping("/getByProductCategory/{category}") // http://localhost:8081/products/getByProductCategory
	public List<Product> findByProductCategory(@PathVariable String category){
		return service.findByProductCategory(category);
		
	}
	
	@GetMapping("/getByProductCategoryAndPriceLessThan/{category}/{price}") // http://localhost:8081/products/getByProductCategoryAndPriceLessThan/Electronics/50000
	public List<Product> findByProductCategoryAndProductPriceLessThan(@PathVariable String category, @PathVariable("price") int productPrice){
		return service.findByProductCategoryAndProductPriceLessThan(category, productPrice);
		
	}
}
