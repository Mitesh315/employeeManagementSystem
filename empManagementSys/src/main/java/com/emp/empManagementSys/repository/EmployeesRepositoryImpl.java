package com.emp.empManagementSys.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.empManagementSys.dto.EmployeesRequest;
import com.emp.empManagementSys.model.Employees;
import com.emp.empManagementSys.model.rowmapper.EmployeeProjectsRowMapper;
import com.emp.empManagementSys.model.rowmapper.EmployeesRowMapper;

@Repository
public class EmployeesRepositoryImpl implements EmployeesRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;    
	
	@Autowired
	private EmployeesRowMapper employeesRowMapper;
	
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

	@Override
	public void updateDepartment(long id, long departmentId) {
		String sql = "UPDATE employees SET department_id = ? WHERE id = ?";
		jdbcTemplate.update(sql, departmentId, id);
	}

	@Override
	public List<Employees> getSortedList() {
		String sql = "SELECT * FROM employees ORDER BY first_name ASC, last_name ASC";
		return jdbcTemplate.query(sql, new EmployeesRowMapper());
	}


	@Override
	public List<Employees> getPaginatedList(int page, int limit) {
		int offset = page * limit;
		String sql = "SELECT * FROM employees ORDER BY first_name ASC LIMIT ? OFFSET ?";
		
		return jdbcTemplate.query(
		        new PreparedStatementCreator() {
		            @Override
		            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		                PreparedStatement ps = connection.prepareStatement(sql);
		                ps.setInt(1, limit);     // Set LIMIT
		                ps.setInt(2, offset);   // Set OFFSET
		                return ps;
		            }
		        },
		        employeesRowMapper
		    );
	}
	
//	@Override
//	@SuppressWarnings("deprecation")
//	public List<Employees> getPaginatedList(int page, int limit) {
//		int offset = (page - 1) * limit;
//		String sql = "SELECT * FROM employees ORDER BY first_name ASC LIMIT ? OFFSET ?";
//		return jdbcTemplate.query(sql, new Object[] {limit,offset},new EmployeesRowMapper());
//
//}
}
