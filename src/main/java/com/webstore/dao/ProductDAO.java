
package com.webstore.dao;

import java.util.List;

import com.webstore.domain.Product;

public interface ProductDAO {
	List<Product> getAllProducts();
	
	void updateStock(String productId, long noOfUnits);
	
	List<Product> getProductsByCategory(String category);
	
	Product getProductById(String productID);
	
	void addProduct(Product product);

	Product getProductByName(String productName);
}
