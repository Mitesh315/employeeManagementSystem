package com.emp.empManagementSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.empManagementSys.repository.EmployeeProjectRepository;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService{
	
	@Autowired
	private EmployeeProjectRepository employeeProjectRepository;

	@Override
	public void setProjectToMultipleEmployee(long projectId, List<Long> ids) {
		employeeProjectRepository.setProjectToMultipleEmployee(projectId, ids);
	}

	@Override
	public void setMultipleProjectToEmployee(long id, List<Long> projectIds) {
		employeeProjectRepository.setMultipleProjectToEmployee(id, projectIds);
		
	}
	

}
