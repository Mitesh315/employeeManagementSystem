package com.emp.empManagementSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.empManagementSys.dto.DepartmentsRequest;
import com.emp.empManagementSys.model.Departments;
import com.emp.empManagementSys.service.DepartmentsService;

@RestController
@RequestMapping("/empSys")
public class DepartmentsController {

	@Autowired
	private DepartmentsService departmentsService;
	
	@PostMapping("/dept")
	public ResponseEntity<String> addDepartment(@RequestBody DepartmentsRequest request) {
		try {
			departmentsService.addDepartment(request);
			return ResponseEntity.ok("Department added successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PutMapping("/dept/{id}")
	public ResponseEntity<String> updateDepartmentId(@PathVariable long id, @RequestParam String name) {
		try {
			departmentsService.updateDepartmentName(id, name);
			return ResponseEntity.ok("Depatment Name updated");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
