package com.ltimindtree.chatbot.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ltimindtree.chatbot.dbutil.DBUtil;
import com.ltimindtree.chatbot.service.QueriesService;

@Service
public class QueriesServiceImpl implements QueriesService {

	Connection connection;
	public QueriesServiceImpl() throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
	}

	@Override
	public List<String> getDepartments() throws SQLException {
		List<String> result = new ArrayList<String>(); 
		PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT department FROM queries;");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			result.add(rs.getString(1));
		}
		return result;
	}

	@Override
	public List<String> getNamesByDepartment(String department) throws SQLException {
		List<String> result = new ArrayList<String>();
		PreparedStatement statement = connection.prepareStatement("SELECT name FROM queries WHERE department = '"+ department +"' ;");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			result.add(rs.getString(1));
		}
		System.out.println("SELECT name FROM queries WHERE department = '"+ department +"' ;");
		
		return result;
		
	}

	@Override
	public String getDescription(String name) throws SQLException {
		String result = null;
		PreparedStatement statement = connection.prepareStatement("SELECT description FROM queries WHERE name = '"+ name +"' ;");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()){
			result = rs.getString(1);
		}
		
		System.out.println("SELECT description FROM queries WHERE name = '"+ name +"' ;");
		return result;
	}

}
