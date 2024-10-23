package com.emp.empManagementSys.service;

import java.util.List;
import java.util.Optional;

import com.emp.empManagementSys.dto.ProjectsRequest;
import com.emp.empManagementSys.model.Projects;

public interface ProjectsService {
	
	void addProject(ProjectsRequest request);
	List<Projects> findAll();
	Optional<Projects> findById(long projectId);
	void updateProjectname(long projectId, String name);
	void deleteProject(long projectId);
}
