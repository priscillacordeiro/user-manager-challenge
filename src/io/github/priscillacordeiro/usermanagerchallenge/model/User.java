package io.github.priscillacordeiro.usermanagerchallenge.model;

import java.util.List;

public class User {

	private Long id;
	private String name;
	private String email;
	private String password;
	private List<Phone> phones;

	public User() {
	}
	
	public User(Long id, String name, String email, String password, List<Phone> phones) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}