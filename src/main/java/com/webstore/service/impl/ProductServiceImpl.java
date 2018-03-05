package com.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.dao.ProductDAO;
import com.webstore.domain.Product;
import com.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public void updateAllStock() {
		System.out.println("yes this method is  alled");
		List<Product> allProducts = productDAO.getAllProducts();
		
		for (Product product : allProducts) {
			if (product.getUnitsInStock() < 500)
				productDAO.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
		}
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productDAO.getProductsByCategory(category);
	}
	
	public Product getProductById(String productID) {
		return productDAO.getProductById(productID);
	}
	
	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}
	
	public Product getProductByName(String productName) {
		return productDAO.getProductByName(productName);
	}
}