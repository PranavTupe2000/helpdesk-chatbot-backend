package com.ltimindtree.chatbot.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ltimindtree.chatbot.service.QueriesService;

@RestController
@CrossOrigin("*")
public class QueriesController {
	@Autowired
	private QueriesService queriesService;
	
	@GetMapping("/query/department")
	public List<String> allDepartments() throws SQLException{
		return queriesService.getDepartments();
	}
	
	@GetMapping("/query/name/{department}")
	public List<String> namesByDepartment(@PathVariable String department) throws SQLException{
		return queriesService.getNamesByDepartment(department);
	}
	
	@GetMapping("/query/description/{name}")
	public String descriptionByName(@PathVariable String name) throws SQLException{
		return queriesService.getDescription(name);
	}
}
