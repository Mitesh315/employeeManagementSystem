package com.emp.empManagementSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.empManagementSys.service.EmployeeProjectService;

@RestController
@RequestMapping("/empSys")
public class EmployeeProjectController {

	@Autowired
	private EmployeeProjectService employeeProjectService;

	@PostMapping("/empProj/{projectId}")
	public ResponseEntity<String> setProjectToMultipleEmployee(@PathVariable long projectId, @RequestBody List<Long> ids) {
		employeeProjectService.setProjectToMultipleEmployee(projectId, ids);
		return ResponseEntity.ok("done");
	}
	
	@PostMapping("/projEmp/{id}")
	public ResponseEntity<String> setMultipleProjectToEmployee(@PathVariable long id,@RequestBody List<Long> projectIds) {
		employeeProjectService.setMultipleProjectToEmployee(id, projectIds);
		return ResponseEntity.ok("done");
	}
	
}
