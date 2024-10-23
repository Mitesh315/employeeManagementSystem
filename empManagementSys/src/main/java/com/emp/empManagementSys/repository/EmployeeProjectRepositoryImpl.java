package com.emp.empManagementSys.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeProjectRepositoryImpl implements EmployeeProjectRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setProjectToMultipleEmployee(long projectId, List<Long> ids) {
		String sql = "INSERT INTO employee_projects (id, project_id) VALUES (?, ?)";
		
		for(long id : ids) {
			jdbcTemplate.update(sql, id, projectId);
		}
		
	}

	@Override
	public void setMultipleProjectToEmployee(long id, List<Long> projectIds) {
    String sql = "INSERT INTO employee_projects (id, project_id) VALUES (?, ?)";
		
		for(long projectId : projectIds) {
			jdbcTemplate.update(sql, id, projectId);
		}
		
	}
	
	
}
