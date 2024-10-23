package com.emp.empManagementSys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.empManagementSys.dto.DepartmentsRequest;
import com.emp.empManagementSys.model.Departments;
import com.emp.empManagementSys.model.rowmapper.DepartmentsRowMapper;

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

	@Override
	public List<Departments> findAll() {
		String sql = "SELECT * FROM departments";
		return jdbcTemplate.query(sql, new DepartmentsRowMapper());
	}

	@Override
	public Optional<Departments> findById(long departmentId) {
		String sql = "SELECT * FROM departments WHERE department_id = ?";
		return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new DepartmentsRowMapper(), departmentId));
	}

	@Override
	public void deleteDepartment(long departmentId) {
		String update = "UPDATE employees SET department_id = null WHERE department_id = ?";
		jdbcTemplate.update(update, departmentId);
		String delete = "DELETE FROM departments WHERE department_id = ?";
		jdbcTemplate.update(delete, departmentId);
	}
	
	
	

	
	
}
