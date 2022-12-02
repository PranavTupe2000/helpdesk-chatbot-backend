package com.ltimindtree.chatbot.service;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
	public int loginValidation(String username, String password) throws SQLException;
	
	public String registerUser(String username, String email, String Password) throws SQLException;
}
