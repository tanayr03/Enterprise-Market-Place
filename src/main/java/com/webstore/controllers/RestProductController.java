package com.webstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webstore.domain.Product;
import com.webstore.service.ProductService;

// By specifying rest controller instead of controller we do not have to use @ResponseBody annotations on top of every method
@RestController
public class RestProductController {
	
	@Autowired
	private ProductService productService;
	
	/*
	 * By writing @ResponseBody you are telling spring to not look for a view for
	 * the particular request This can return only JSON as it is returning a list of
	 * products and for XML we have to make a list class or something...
	 *
	 */
	// Commenting responseBody as we have mentioned the controller as restcontroller
	// @ResponseBody
	// produces -> only that value specified will be supported.
	@RequestMapping(value = "/productsRest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductsJson() {
		List<Product> pList = productService.getAllProducts();
		return pList;
	}
	
	/*
	 * By writing @ResponseBody you are telling spring to not look for a view for
	 * the particular request This can return only JSON as it is returning a list of
	 * products and for XML we have to make a list class or something... produces ->
	 * only that value specified will be supported.
	 */
	// Commenting responseBody as we have mentioned the controller as restcontroller
	// @ResponseBody
	@RequestMapping(value = "/productsRest/{product}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductJson(@PathVariable("product") String productName) {
		System.out.println("name" + productName);
		return productService.getProductByName(productName);
	}
	
	/*
	 * By writing @ResponseBody you are telling spring to not look for a view for
	 * the particular request This can return both JSON and XML formats produces ->
	 * only that value specified will be supported. TO return xml response
	 * http://www.beingjavaguys.com/2014/05/xml-response-with-responsebody.html
	 */
	// Commenting responseBody as we have mentioned the controller as restcontroller
	// @ResponseBody
	@RequestMapping(value = "/productsXML", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductsXMLOrJSON() {
		System.out.println("coming here");
		List<Product> pList = productService.getAllProducts();
		Product p2 = pList.get(0);
		return p2;
	}
	
	// PUT example
	// @RequestBody annotation converts json or xml message to corresponding java
	// object.
	// through ResponseEntity<Boolean>(true, HttpStatus.OK) we can pass any status
	// code as well as response body
	@RequestMapping(value = "/products/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> putInProducts(@PathVariable("name") String productName, @RequestBody Product product) {
		System.out.println(productName);
		System.out.println("productname" + product.getName());
		System.out.println("id" + product.getProductId());
		System.out.println("productname" + product.getCategory());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("key1", "value1");
		httpHeaders.add("key2", "value2");
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.CREATED);
	}
	
}
