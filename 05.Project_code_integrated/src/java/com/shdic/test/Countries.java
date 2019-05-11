package com.shdic.test;




public class Countries {
	public Countries(String email,String name ){
		this.setEmail(email);
		this.setName(name);
}
	private String email;
	private String name;

	public void setEmail(String email) {
	this.email = email;
	}
	public String getEmail() {
	return email;
	}

	
	public void setName(String name) {
	this.name = name;
	}
	public String getName() {
	return name;
	}
}