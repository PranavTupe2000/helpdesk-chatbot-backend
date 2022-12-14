package com.ltimindtree.chatbot.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ltimindtree.chatbot.dbutil.DBUtil;
import com.ltimindtree.chatbot.model.Message;
import com.ltimindtree.chatbot.model.Users;
import com.ltimindtree.chatbot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Connection connection;
	int flag = 0;
	public UserServiceImpl() throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
	}
	
	@Override
	public int loginValidation(String username, String password) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = '"+username+"' AND password = '" +password+"';" );
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			if(rs.getString(2).equals(username)) {
				flag = 1;
			} else {
				flag = 0;
				System.out.println("Invalide Usertname/Password");
			}
		}
		System.out.println("Impl Flag: " + flag);
		return flag;
	}

	@Override
	public String registerUser(String username, String email, String password, String firstname, String lastname, String phone) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = '"+username+ "' AND email = '" +email+"';");
		ResultSet rs = statement.executeQuery();
		while(rs.next()){
			if(rs.getString(2).equals(username) && rs.getString(3).equals(email)) {
				return "User already exsists";
			} 
		}
		PreparedStatement statement1 = connection.prepareStatement("INSERT INTO users (username, email, password, firstname, lastname, phone) VALUES (?, ?, ?, ?, ?, ?);");
		statement1.setString(1, username);
		statement1.setString(2, email);
		statement1.setString(3, password);
		statement1.setString(4, firstname);
		statement1.setString(5, lastname);
		statement1.setString(6, phone);
		statement1.executeLargeUpdate();
		
		return "Success";
	}

	@Override
	public Message userLogin(Users user) throws SQLException {
		Message msg = new Message("Failed");
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? ;");
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			if(rs.getString(2).equals(user.getUsername())) {
				msg.setMessage("Success");
			} else {
				msg.setMessage("Failed");
			}
		}
		
		return msg;
	}

}
