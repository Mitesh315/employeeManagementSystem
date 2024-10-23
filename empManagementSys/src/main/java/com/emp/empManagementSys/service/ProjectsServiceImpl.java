package com.emp.empManagementSys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.empManagementSys.dto.ProjectsRequest;
import com.emp.empManagementSys.model.Projects;
import com.emp.empManagementSys.repository.ProjectsRepository;

@Service
public class ProjectsServiceImpl implements ProjectsService{

	@Autowired
	private ProjectsRepository projectRepository;
	
	@Override
	public void addProject(ProjectsRequest request) {
		projectRepository.addProject(request);
	}

	@Override
	public List<Projects> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Optional<Projects> findById(long projectId) {
		return projectRepository.findById(projectId);
	}

	@Override
	public void updateProjectname(long projectId, String name) {
		projectRepository.updateProjectName(projectId, name);
	}

	@Override
	public void deleteProject(long projectId) {
		projectRepository.deleteProject(projectId);
		
	}

}
