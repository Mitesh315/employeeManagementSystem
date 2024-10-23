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

import com.emp.empManagementSys.dto.EmployeesRequest;
import com.emp.empManagementSys.model.Employees;
import com.emp.empManagementSys.service.EmployeesService;

@RestController
@RequestMapping("/empSys")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@PostMapping("/emp")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeesRequest request) {
		try {
			employeesService.addEmployee(request);
			return ResponseEntity.ok("Employee added successfully");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PutMapping("/emp/{id}")
	public ResponseEntity<String> updateEmployeeEmail(@PathVariable long id, @RequestParam String email) {
		try {
			int rowsAffected = employeesService.updateEmployeeEmail(id, email);
			if (rowsAffected > 0) {
				return ResponseEntity.ok("Employee updated successfully");
			} else {
				return ResponseEntity.badRequest().body("Employee with id " + id + " do not exist");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping("/emp")
	public ResponseEntity<List<Employees>> findAll() {
		try {
			return ResponseEntity.ok(employeesService.findAll());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Optional<Employees>> findById(@PathVariable long id) {
		try {
			employeesService.findById(id);
			return ResponseEntity.ok(employeesService.findById(id));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		try {
			employeesService.deleteEmployee(id);
			return ResponseEntity.ok("Employee deleted successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PutMapping("/emp/updateDept/{id}")
	public ResponseEntity<String> updateDepartment(@PathVariable long id, @RequestParam long departmentId) {
		try {
			employeesService.updateDepartment(departmentId, id);
			return ResponseEntity.ok("Department updated successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@GetMapping("/emp/sortedList")
	public ResponseEntity<List<Employees>> getSortedList() {
		try {
			return ResponseEntity.ok(employeesService.getSortedList());
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/emp/paginatedList")
	public ResponseEntity<List<Employees>> getPaginatedList(@RequestParam int page, @RequestParam int limit) {
		try {
			return ResponseEntity.ok(employeesService.getPaginatedList(page, limit));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
