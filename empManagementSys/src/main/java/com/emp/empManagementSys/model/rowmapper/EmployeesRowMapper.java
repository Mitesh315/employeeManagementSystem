package com.emp.empManagementSys.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emp.empManagementSys.model.Departments;
import com.emp.empManagementSys.model.Employees;

public class EmployeesRowMapper implements RowMapper<Employees>{
	
	Employees employees = new Employees();

	@Override
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		employees.setId(rs.getLong("id"));
		employees.setFirstName(rs.getString("first_name"));
		employees.setLastName(rs.getString("last_name"));
		employees.setEmail(rs.getString("email"));
		employees.setDepartmentId(rs.getLong("department_id"));
		
		return employees;
	}
	
}
