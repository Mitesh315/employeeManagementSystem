package com.emp.empManagementSys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.empManagementSys.dto.EmployeesRequest;
import com.emp.empManagementSys.model.Employees;
import com.emp.empManagementSys.model.rowmapper.EmployeesRowMapper;

@Repository
public class EmployeesRepositoryImpl implements EmployeesRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addEmployee(EmployeesRequest request) {
		String sql = "INSERT INTO employees (first_name, last_name, email, department_id) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, request.getFirstName(), request.getLastName(), request.getEmail(), request.getDepartmentId());	
	}

	@Override
	public int updateEmployeeEmail(long id, String email) {
		String sql = "UPDATE employees SET email = ? WHERE id = ?";
		return jdbcTemplate.update(sql, email, id);
	}

	@Override
	public List<Employees> findAll() {
		String sql = "SELECT * FROM employees";
		return jdbcTemplate.query(sql, new EmployeesRowMapper());
	}

	@Override
	public Optional<Employees> findById(long id) {
		String sql =  "SELECT * FROM employees where id = ?";
		return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new EmployeesRowMapper(), id));
	}

	@Override
	public void deleteEmployee(long id) {
		String sql = "DELETE FROM employees where id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	

}
