package com.ltimindtree.chatbot.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltimindtree.chatbot.model.Users;
import com.ltimindtree.chatbot.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("user/{username}/{password}")
	public int userLogin(@PathVariable String username, @PathVariable String password) throws SQLException {
		int flag = userService.loginValidation(username, password);
		System.out.println("Controller flag: "+flag);
		return flag;
 	}
	
	@PostMapping("user/register")
	public String userRegister(@RequestBody Users user) throws SQLException {	

		String msg = userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
		System.out.println(user);
		return msg;
	}
}
