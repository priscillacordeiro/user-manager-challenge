package io.github.priscillacordeiro.usermanagerchallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 3, nullable = false)
	private int ddd;
	
	@Column(length = 20, nullable = false)
	private String number;
	
	@Column(length = 20)
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Phone(){
	}
	
	public Phone(int ddd, String number, String type, User user) {
		this.ddd = ddd;
		this.number = number;
		this.type = type;
		this.user = user;
	}
	
	public Phone(Long id, int ddd, String number, String type, User user) {
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.type = type;
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getDdd() {
		return ddd;
	}
	
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}