package com.webstore.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.lab2.Address;
import edu.sjsu.cmpe275.lab2.Player;
import edu.sjsu.cmpe275.lab2.Sponsor;

@RestController
public class RestGameController {
	
	@RequestMapping(value = "/player", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPlayer(HttpServletRequest request) {
		
		System.out.println("Entered create player method ");
		
		// These three are required
		String firstname = request.getParameter("firstname");
		System.out.println("name is " + firstname);
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		if (null == firstname || null == lastname || null == email) {
			// THESE FIELDS WERE REQUIRED
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String description = request.getParameter("description");
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		Address address = new Address(street, city, state, zip);
		
		String sponsorId = request.getParameter("sponsor");
		// Now Validate sponsor id
		
		Sponsor sponsor = new Sponsor();
		
		// sponsor = getSponsorFromDatabase(sponsorId);
		// if (sponsor == null) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		
		// Should not contain opponents as a parameter
		
		Player newPlayer = new Player();
		
		newPlayer.setFirstname(firstname);
		newPlayer.setLastname(lastname);
		newPlayer.setEmail(email);
		newPlayer.setDescription(description);
		newPlayer.setAddress(address);
		newPlayer.setSponsor(sponsor);
		
		// Add newPlayerToDatabase
		addingNewPlayer(newPlayer);
		// addingDummyAddress(address);
		// fetchingDummyAddress(address);
		// updatingDummyAddress(address);
		// updatingDummyAddressUsingHQL(address);
		// fetchingAllAddresses(address);
		return new ResponseEntity<>(newPlayer, HttpStatus.OK);
	}
	
	private void addingNewPlayer(Player newPlayer) {
		
		System.out.println("entering hibernate code");
		newPlayer.setAddress(new Address("aa", "city", "st", "zp"));
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Player.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(newPlayer);
			session.getTransaction().commit();
			System.out.println("Row added!");
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private void addingDummyAddress(Address address) {
		
		address = new Address("str", "ct", "st", "zp");
		System.out.println("entering hibernate code");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(address);
			session.getTransaction().commit();
			System.out.println("Row added!");
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private void fetchingDummyAddress(Address address) {
		
		address = new Address();
		System.out.println("entering hibernate code");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			address = session.get(Address.class, 1);
			
			System.out.println(address);
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private void updatingDummyAddress(Address address) {
		
		address = new Address();
		System.out.println("entering hibernate code");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			address = session.get(Address.class, 1);
			address.setZip("92246");
			address.setCity("san jose");
			address.setState("ca");
			address.setStreet("367 stockton avenue");
			
			System.out.println(address);
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private void deletingDummyRecords(Address address) {
		
		address = new Address();
		System.out.println("entering hibernate code");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			address = session.get(Address.class, 1);
			session.delete(address);
			session.getTransaction().commit();
			System.out.println(address);
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	/*
	 * private void deletingDummyRecordsUsingHQL(Address address) {
	 * 
	 * address = new Address(); System.out.println("entering hibernate code");
	 * 
	 * SessionFactory factory = new
	 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.
	 * class).buildSessionFactory(); Session session = factory.getCurrentSession();
	 * try { session.beginTransaction(); address = session.get(Address.class, 1);
	 * session.delete(address); session.getTransaction().commit();
	 * System.out.println(address);
	 * 
	 * } finally { session.close(); factory.close(); } }
	 */
	
	private void updatingDummyAddressUsingHQL(Address address) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			session.createQuery("update address set zip='92246' where state='st'").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	private void fetchingAllAddresses(Address address) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			List<Address> addressList = session.createQuery("from address where city='san jose'" + "OR state='st'").getResultList();
			
			for (Address a : addressList) {
				System.out.println(a);
			}
			System.out.println("hiiiii :      :       :  ");
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
	
	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPlayer(HttpServletRequest request) {
		
		System.out.println("Entered get player method ");
		
		String id = request.getParameter("id");
		System.out.println("id is" + id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Player player = new Player();
		
		// player = getPlayerById(id);
		
		// if (null == player) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		
		return new ResponseEntity<>(player, HttpStatus.OK);
	}
	
	// id ?
	
	@RequestMapping(value = "/player/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePlayer(HttpServletRequest request) {
		
		System.out.println("Entered update player method ");
		
		String id = request.getParameter("id");
		System.out.println("id is" + id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Player> opponents = new ArrayList<>();
		
		// if(getPlayerFromId(id)==null) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		// else {
		// opponents = getPlayerFromId(id).getOPPONENTS();
		// }
		
		// These three are required
		String firstname = request.getParameter("firstname");
		System.out.println("name is " + firstname);
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		if (null == firstname || null == lastname || null == email) {
			// THESE FIELDS WERE REQUIRED
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String description = request.getParameter("description");
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		Address address = new Address(street, city, state, zip);
		
		String sponsorId = request.getParameter("sponsor");
		// Now Validate sponsor id
		
		Sponsor sponsor = new Sponsor();
		
		// sponsor = getSponsorFromDatabase(sponsorId);
		// if (sponsor == null) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		
		// Should not contain opponents as a parameter
		
		Player player = new Player();
		
		player.setFirstname(firstname);
		player.setLastname(lastname);
		player.setEmail(email);
		player.setDescription(description);
		player.setAddress(address);
		player.setSponsor(sponsor);
		player.setOpponents(opponents);
		
		// Add newPlayerToDatabase
		return new ResponseEntity<>(player, HttpStatus.OK);
		
		// player = getPlayerById(id);
		
		// if (null == player) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
	}
	
	@RequestMapping(value = "/player/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePlayer(HttpServletRequest request) {
		
		System.out.println("Entered get player method ");
		
		String id = request.getParameter("id");
		System.out.println("id is" + id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Player player = new Player();
		
		// player = getPlayerById(id);
		
		// if (null == player) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		// Remove the player hehe
		return new ResponseEntity<>(player, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sponsor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createSponsor(HttpServletRequest request) {
		
		System.out.println("Entered create Sponsor method ");
		String name = request.getParameter("name");
		System.out.println("name is " + name);
		
		if (null == name) {
			// This field is required
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String description = request.getParameter("description");
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		Address address = new Address(street, city, state, zip);
		
		Sponsor sponsor = new Sponsor();
		sponsor.setName(name);
		sponsor.setDescription(description);
		sponsor.setAddress(address);
		
		// Add sponsor to database
		return new ResponseEntity<>(sponsor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sponsor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSponsor(HttpServletRequest request) {
		
		System.out.println("Entered get sponsor method ");
		
		String id = request.getParameter("id");
		System.out.println("id is" + id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Sponsor sponsor = new Sponsor();
		
		// sponsor = getSponsorById(id);
		
		// if (null == sponsor) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		
		return new ResponseEntity<>(sponsor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sponsor/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateSponsor(HttpServletRequest request) {
		
		System.out.println("Entered update Sponsor method ");
		
		String id = request.getParameter("id");
		System.out.println("id is" + id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		long sponsorId = Long.valueOf(id);
		
		String name = request.getParameter("name");
		System.out.println("name is " + name);
		
		if (null == name) {
			// THESE FIELDS WERE REQUIRED
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String description = request.getParameter("description");
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		Address address = new Address(street, city, state, zip);
		// Now Validate sponsor id
		
		Sponsor sponsor = new Sponsor();
		
		// sponsor = getSponsorFromDatabase(sponsorId);
		// if (sponsor == null) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
		
		// Should not contain opponents as a parameter
		sponsor.setName(name);
		sponsor.setDescription(description);
		sponsor.setId(sponsorId);
		sponsor.setAddress(address);
		
		// Add Sponsor to database
		return new ResponseEntity<>(sponsor, HttpStatus.OK);
		
		// sponsor = getSponsorById(id);
		
		// if (null == player) {
		// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		// }
	}
	
}
