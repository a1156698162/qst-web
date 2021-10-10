package com.ssp.bean;

import java.util.Date;

public class User {
	private int id;
	private String username ;
	private String password;
	private String code;
	private String sessionCode;
	private int userRole;
	private int userState;
	private String email;
	
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSessionCode() {
		return sessionCode;
	}
	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}
	public User() {
		super();
	}
	public User(String username, String password, String code, String sessionCode) {
		super();
		this.username = username;
		this.password = password;
		this.code = code;
		this.sessionCode = sessionCode;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password,  String email,int userRole, int userState) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
		this.userState = userState;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", code=" + code
				+ ", sessionCode=" + sessionCode + ", userRole=" + userRole + ", userState=" + userState + ", email="
				+ email + "]";
	}
	
	
}
