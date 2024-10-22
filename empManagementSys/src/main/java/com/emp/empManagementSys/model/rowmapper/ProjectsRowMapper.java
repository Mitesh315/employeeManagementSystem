package com.emp.empManagementSys.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emp.empManagementSys.model.Projects;

public class ProjectsRowMapper implements RowMapper<Projects>{

	Projects projects = new Projects();

	@Override
	public Projects mapRow(ResultSet rs, int rowNum) throws SQLException {
		projects.setId(rs.getLong("id"));
		projects.setName(rs.getString("name"));
		projects.setDescription(rs.getString("description"));
		return projects;
	}
	
	
}
