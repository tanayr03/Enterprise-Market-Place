package com.webstore.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webstore.dao.ProductDAO;
import com.webstore.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> getAllProducts() {
		String sql = "select * from products ";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<Product> products = new ArrayList<>();
		for (Map row : rows) {
			Product product = new Product();
			product.setProductId((String.valueOf((int) row.get("id"))));
			product.setName((String) row.get("name"));
			product.setDescription((String) row.get("description"));
			product.setManufacturer((String) row.get("manufacturer"));
			product.setCategory((String) row.get("category"));
			product.setUnitsInStock(Integer.valueOf((String) row.get("unitsInStock")));
			product.setUnitPrice((BigDecimal) row.get("unitPrice"));
			product.setImage((String) row.get("image"));
			products.add(product);
		}
		return products;
	}
	
	public void updateStock(String productId, long noOfUnits) {
		// TODO Auto-generated method stub
		System.out.println("this is called");
		
	}
	
	public List<Product> getProductsByCategory(String category) {
		Product iphone = new Product("p1", "iPhone 6s", new BigDecimal(500));
		Product iphone2 = new Product("p2", "iPhone 7s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iphone.setCategory("Smartphone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		List<Product> result = new ArrayList<Product>();
		result.add(iphone2);
		result.add(iphone);
		return result;
	}
	
	public Product getProductById(String productID) {
		String sql = "select * from products where id ";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<Product> products = new ArrayList<>();
		for (Map row : rows) {
			Product product = new Product();
			product.setProductId((String.valueOf((int) row.get("id"))));
			product.setName((String) row.get("name"));
			product.setDescription((String) row.get("description"));
			product.setManufacturer((String) row.get("manufacturer"));
			product.setCategory((String) row.get("category"));
			product.setUnitsInStock(Integer.valueOf((String) row.get("unitsInStock")));
			product.setUnitPrice((BigDecimal) row.get("unitPrice"));
			product.setImage((String) row.get("image"));
			products.add(product);
		}
		
		
		
		// TODO Auto-generated method stub
		if (productID.equalsIgnoreCase("p1")) {
			Product p = new Product("p1", "iPhone 6s", new BigDecimal(500));
			p.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
			p.setCategory("Smartphone");
			p.setManufacturer("Apple");
			p.setImage("/resources/images/iphone6s.png");
			return p;
		} else {
			Product p = new Product("p2", "iPhone 6s", new BigDecimal(500));
			p.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
			p.setCategory("Smartphone");
			p.setManufacturer("Apple");
			p.setImage("/resources/images/samsungs8.png");
			
			return p;
		}
	}
	
	public void addProduct(Product product) {
		System.out.println("Adding a product in DB");
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO products (name, description, manufacturer, category, unitsInStock, unitsInOrder, discontinued, c, image, unitPrice)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getManufacturer(), product.getCategory(), product.getUnitsInStock(), product.getUnitsInOrder(), false, product.getCondition(), product.getImage(), product.getUnitPrice());
	}
	
	public Product getProductByName(String productName) {
		// TODO Auto-generated method stub
		Product p = new Product("p2", "iPhone 6s", new BigDecimal(500));
		p.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		p.setCategory("Smartphone");
		p.setManufacturer("Apple");
		p.setImage("/resources/images/samsungs8.png");
		return p;
	}
	
}
