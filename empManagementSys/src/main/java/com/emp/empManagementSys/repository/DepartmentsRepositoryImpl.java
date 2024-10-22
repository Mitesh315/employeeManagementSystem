package com.emp.empManagementSys.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.empManagementSys.dto.DepartmentsRequest;

@Repository
public class DepartmentsRepositoryImpl implements DepartmentsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addDepartment(DepartmentsRequest request) {
		String sql = "INSERT INTO departments (name, description) VALUES (?, ?)";
		jdbcTemplate.update(sql, request.getName(), request.getDescription());
	}

	@Override
	public int updateDepartmentName(long id, String name) {
		String sql = "UPDATE departments SET name = ? WHERE department_id = ?";
		return jdbcTemplate.update(sql, name, id);
	}
	
	

	
	
}
