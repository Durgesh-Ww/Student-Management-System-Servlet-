package com.jsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
	private String name;
	
	@Column(nullable = false,unique = true,updatable = true)
	private String mail;
	
	@Column(nullable = false,unique = true,updatable = true)
	private long conact;
	
	@Column(nullable = false,updatable = false)
	private String gender;
	
	@Column(nullable = false,updatable = true)
	private String address;
	
	@Column(nullable = false,updatable = false)
	private String branch;
	
	@Column(nullable = false,updatable = true)
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getConact() {
		return conact;
	}
	public void setConact(long conact) {
		this.conact = conact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
