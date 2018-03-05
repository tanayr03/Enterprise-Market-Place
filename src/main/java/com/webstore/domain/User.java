package com.webstore.domain;

public class User {
	/*
	 * When we use initBinder for our custom validator , default spring validator
	 * will no be called hence, we need to add all the validations in the custom
	 * validator.
	 * 
	 * Annotations on the User class will not do any validation so just remove them.
	 */
	
	// In order for this annotation to work you also need to place valid annotation
	// on the controller;'s method with the @Modelattribute annotation
	// Also including validator library for bean validations
	
	// @Size(min = 2, max = 45)
	// @NotEmpty
	private String username;
	
	// @Size(max = 45)
	// @NotEmpty
	private String password;
	
	// @Size(max = 45)
	private String firstname;
	
	// @Size(max = 45)
	private String lastname;
	
	// @Size(max = 45)
	// @NotEmpty
	private String email;
	
	private Address address;
	
	// @Digits(integer = 10, fraction = 0)
	private int phone;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public void setAddress(String string) {
		// TODO Auto-generated method stub
		System.out.println("does nothing for now");
		
	}
	
}