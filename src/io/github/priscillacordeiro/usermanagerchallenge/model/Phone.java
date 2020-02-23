package io.github.priscillacordeiro.usermanagerchallenge.model;

public class Phone {

	private Long id;
	private int ddd;
	private String number;
	private String type;
	
	public Phone(){
	}
	
	public Phone(Long id, int ddd, String number, String type) {
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.type = type;
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

}