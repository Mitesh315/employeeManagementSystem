package com.emp.empManagementSys.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emp.empManagementSys.model.EmployeeProjects;

public class EmployeeProjectsRowMapper implements RowMapper<EmployeeProjects>{
	
	EmployeeProjects employeeProjects = new EmployeeProjects();

	@Override
	public EmployeeProjects mapRow(ResultSet rs, int rowNum) throws SQLException {
		employeeProjects.setEmployeeId(rs.getLong("employee_id"));
		employeeProjects.setProjectId(rs.getLong("project_id"));
		return employeeProjects;
	}
	
	
}
