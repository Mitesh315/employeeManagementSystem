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

import com.emp.empManagementSys.dto.ProjectsRequest;
import com.emp.empManagementSys.model.Projects;
import com.emp.empManagementSys.service.ProjectsService;

@RestController
@RequestMapping("/empSys")
public class ProjectsController {

	@Autowired
	private ProjectsService projectService;
	
	@PostMapping("/proj")
	public ResponseEntity<String> addProject(@RequestBody ProjectsRequest request) {
		try {
				projectService.addProject(request);
				return ResponseEntity.ok("Prooject added successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/proj")
	public ResponseEntity<List<Projects>> findAll() {
		try {
			return ResponseEntity.ok(projectService.findAll());
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/proj/{projectId}")
	public ResponseEntity<Optional<Projects>> findById(@PathVariable long projectId) {
		try {
			return ResponseEntity.ok(projectService.findById(projectId));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PutMapping("/proj/{projectId}")
	public ResponseEntity<String> updateProjectName(@PathVariable long projectId, @RequestParam String name) {
		try {
			projectService.updateProjectname(projectId, name);
			return ResponseEntity.ok("Project updated successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@DeleteMapping("/proj/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable long projectId) {
		try {
			projectService.deleteProject(projectId);
			return ResponseEntity.ok("Project deleted successfully");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
