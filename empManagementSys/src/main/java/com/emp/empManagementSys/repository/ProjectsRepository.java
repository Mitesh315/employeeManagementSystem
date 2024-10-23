package com.emp.empManagementSys.repository;

import java.util.List;
import java.util.Optional;

import com.emp.empManagementSys.dto.ProjectsRequest;
import com.emp.empManagementSys.model.Projects;

public interface ProjectsRepository {
	
	void addProject(ProjectsRequest request);
	List<Projects> findAll();
	Optional<Projects> findById(long projectId);
	void updateProjectName(long projectId, String name);
	void deleteProject(long projectId);

}
