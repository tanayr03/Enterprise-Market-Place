package edu.sjsu.cmpe275.lab2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "player")
@Table(name = "player")
public class Player {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "description")
	private String description;
	
	private Address address;
	
	private Sponsor sponsor;
	
	private List<Player> opponents;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Sponsor getSponsor() {
		return sponsor;
	}
	
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
	public List<Player> getOpponents() {
		return opponents;
	}
	
	public void setOpponents(List<Player> opponents) {
		this.opponents = opponents;
	}
}
