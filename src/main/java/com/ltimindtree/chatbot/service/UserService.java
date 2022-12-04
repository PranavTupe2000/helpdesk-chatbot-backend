package com.ltimindtree.chatbot.service;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ltimindtree.chatbot.model.Message;
import com.ltimindtree.chatbot.model.Users;

@Repository
public interface UserService {
	public int loginValidation(String username, String password) throws SQLException;
	
	public Message userLogin(Users user) throws SQLException;
	
	public String registerUser(String username, String email, String password, String firstname, String lastname, String phone) throws SQLException;
}
