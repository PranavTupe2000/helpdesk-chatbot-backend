package com.ltimindtree.chatbot.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltimindtree.chatbot.model.Admin;
import com.ltimindtree.chatbot.model.Message;
import com.ltimindtree.chatbot.model.Queries;

import com.ltimindtree.chatbot.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/all")
	public List<Queries> getAllQueries() throws SQLException {
		return adminService.allQueries();
	}
	
	@PostMapping("/admin/add")
	public String addQuery(@RequestBody Queries queries) throws SQLException {
		return adminService.addQuery(queries.getName(), queries.getDepartment(), queries.getDescription());
	}
	
	@PutMapping("/admin/update")
	public String updateQuery(@RequestBody Queries queries) throws SQLException {
		return adminService.updateQuery(queries.getId(), queries.getName(), queries.getDepartment(), queries.getDescription());
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public String deleteQuery(@PathVariable int id) throws SQLException {
		return adminService.deleteQuery(id);
	}
	
	@PostMapping("admin/login")
	public Message userLogin(@RequestBody Admin admin) throws SQLException {
		return adminService.adminLogin(admin);
	}

}
