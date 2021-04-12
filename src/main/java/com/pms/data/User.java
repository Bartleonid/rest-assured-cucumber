package com.pms.data;

public class User {

	public String email;
	public String password;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	private final static String USER = System.getenv("USERAQA");
	private final static String PASSWORD = System.getenv("PASS");
	
	public static String getUser() {
		return USER;
	}

	public static String getPassword() {
		return PASSWORD;
	}
	
	public static String getUser(String username) {
		return System.getenv(username);
	}

	public static String getPassword(String password) {
		return System.getenv(password);
	}
}
