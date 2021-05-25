package com.example.login.dto;

import java.util.Map;

public class UserDTO {
	private int idNo ;
	private String username;
	private String email;
	private String password;
	
	public UserDTO(int idNo ,String username, String email, String password) {
		super();
		this.idNo = idNo;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO() {
		super();
	}
	

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public int getId() {
		return getIdNo();
	}
	
}
