package com.emp.empManagementSys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<String> updateDepartmentName(@PathVariable long id, @RequestParam String name) {
		try {
			departmentsService.updateDepartmentName(id, name);
			return ResponseEntity.ok("Depatment Name updated");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/dept")
	public List<Departments> findAll() {
		try {
			return departmentsService.findAll();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	@GetMapping("/dept/{departmentId}")
	public ResponseEntity<Optional<Departments>> findById(@PathVariable long departmentId) {
		try {
			return ResponseEntity.ok(departmentsService.findById(departmentId));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@DeleteMapping("/dept/{departmentId}")
	public ResponseEntity<String> deleteDepartment(@PathVariable long departmentId) {
		try {
			departmentsService.deleteDepartment(departmentId);
			return ResponseEntity.ok("Department deleted successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
