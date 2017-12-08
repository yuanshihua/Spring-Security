package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
	private String username;

	public User(String username) {
		super();
		this.username = username;
	}
	
}
