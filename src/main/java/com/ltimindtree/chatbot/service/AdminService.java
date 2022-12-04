package com.ltimindtree.chatbot.service;

import java.sql.SQLException;
import java.util.List;

import com.ltimindtree.chatbot.model.Admin;
import com.ltimindtree.chatbot.model.Message;
import com.ltimindtree.chatbot.model.Queries;


public interface AdminService {
	public List<Queries> allQueries() throws SQLException;
	
	public String addQuery(String name, String department, String description) throws SQLException;
	
	public String updateQuery(int id, String name, String department, String description) throws SQLException;
	
	public String deleteQuery(int id) throws SQLException;
	
	public Message adminLogin(Admin admin) throws SQLException;
}
