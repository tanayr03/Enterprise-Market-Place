package com.webstore.service;

import java.util.List;

import com.webstore.domain.Product;

public interface ProductService {
	
	void updateAllStock();
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);
	
	Product getProductById(String productID);
	
	Product getProductByName(String productName);
	
	void addProduct(Product product);
	
}
