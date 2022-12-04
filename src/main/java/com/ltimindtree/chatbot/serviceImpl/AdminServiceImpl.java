package com.ltimindtree.chatbot.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ltimindtree.chatbot.dbutil.DBUtil;
import com.ltimindtree.chatbot.model.Admin;
import com.ltimindtree.chatbot.model.Message;
import com.ltimindtree.chatbot.model.Queries;

import com.ltimindtree.chatbot.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	Connection connection;
	public AdminServiceImpl() throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
	}
	
	@Override
	public List<Queries> allQueries() throws SQLException {
		List<Queries> result = new ArrayList<Queries>();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM queries");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			Queries q =new Queries(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			result.add(q);
		}
		return result;
	}
	
	@Override
	public String addQuery(String name, String department, String description) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("INSERT INTO queries(name, department, description) VALUES (? , ? , ?);");
		statement.setString(1, name);
		statement.setString(2, department);
		statement.setString(3, description);
		int i = (int) statement.executeLargeUpdate();
		return "Row affected: " + i;
	}

	@Override
	public String updateQuery(int id, String name, String department, String description) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("UPDATE queries SET name = ? , department = ? , description = ? WHERE ID = ?");
		statement.setString(1, name);
		statement.setString(2, department);
		statement.setString(3, description);
		statement.setInt(4, id);
		int i = (int) statement.executeLargeUpdate();
		return "Row affected: " + i;
	}

	@Override
	public String deleteQuery(int id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("DELETE FROM queries WHERE id = ? ;");
		statement.setInt(1, id);
		int i = (int) statement.executeLargeUpdate();
		return "Row affected: " + i;
	}

	@Override
	public Message adminLogin(Admin admin) throws SQLException {
		Message msg = new Message("Failed");
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ? ;");
		statement.setString(1, admin.getUsername());
		statement.setString(2, admin.getPassword());
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			if(rs.getString(2).equals(admin.getUsername())) {
				msg.setMessage("Success");
			} else {
				msg.setMessage("Failed");
			}
		}
		
		return msg;
	}

}
