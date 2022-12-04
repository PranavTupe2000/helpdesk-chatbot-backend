package com.ltimindtree.chatbot.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface QueriesService {
	public List<String> getDepartments() throws SQLException;
	
	public List<String> getNamesByDepartment(String department) throws SQLException;
	
	public String getDescription(String name) throws SQLException;
}
