package com.emp.empManagementSys.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emp.empManagementSys.model.Departments;

public class DepartmentsRowMapper implements RowMapper<Departments>{

	Departments departments = new Departments();

	@Override
	public Departments mapRow(ResultSet rs, int rowNum) throws SQLException {
		departments.setId(rs.getLong("id"));
		departments.setName(rs.getString("name"));
		departments.setDescription(rs.getNString("description"));
		return departments;
	}
	
}
