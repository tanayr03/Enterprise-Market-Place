package com.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//Adding this tag will ignore condition from the json, to ignore multiple fields add , separated.
@JsonIgnoreProperties({ "condition", "discontinued" })

// This is added for bean to support xml return when controller returns bean in
// xml format
@XmlRootElement(name = "product")
// @JsonInclude(JsonInclude.Include.NON_NULL)
// By above line only not null atrbts are included in json response
public class Product implements Serializable {
	
	private static final long serialVersionUID = 3678107792576131001L;
	
	private String productId;
	
	// by specifying this tag you can alter name and change its value to
	// product_name in your json
	@JsonProperty("product_name")
	private String name;
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private long unitsInOrder;
	private boolean discontinued;
	private String condition;
	private String image;
	
	public Product() {
		super();
	}
	
	public Product(String productId, String name, BigDecimal unitPrice) {
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	// add setters and getters for all the fields here
	
	public String getProductId() {
		return productId;
	}
	
	@XmlElement
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	@XmlElement
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	@XmlElement
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getCategory() {
		return category;
	}
	
	@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}
	
	public long getUnitsInStock() {
		return unitsInStock;
	}
	
	@XmlElement
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	
	public long getUnitsInOrder() {
		return unitsInOrder;
	}
	
	@XmlElement
	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}
	
	public boolean isDiscontinued() {
		return discontinued;
	}
	
	@XmlElement
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	
	public String getCondition() {
		return condition;
	}
	
	@XmlElement
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getImage() {
		return image;
	}
	
	@XmlElement
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
}