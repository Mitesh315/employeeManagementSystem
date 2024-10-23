package com.emp.empManagementSys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.empManagementSys.dto.ProjectsRequest;
import com.emp.empManagementSys.model.Projects;
import com.emp.empManagementSys.model.rowmapper.ProjectsRowMapper;

@Repository
public class ProjectsRepositoryImpl implements ProjectsRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addProject(ProjectsRequest request) {
		String sql = "INSERT INTO projects (name, description) VALUES (?, ?)";
		jdbcTemplate.update(sql, request.getName(), request.getDescription());
	}

	@Override
	public List<Projects> findAll() {
		String sql = "SELECT * FROM projects";
		return jdbcTemplate.query(sql, new ProjectsRowMapper());
	}

	@Override
	public Optional<Projects> findById(long projectId) {
		String sql = "SELECT * FROM projects WHERE project_id = ?";
		return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new ProjectsRowMapper(), projectId));
	}

	@Override
	public void updateProjectName(long projectId, String name) {
		String sql = "UPDATE projects SET name = ? WHERE project_id = ?";
		jdbcTemplate.update(sql, name, projectId);
	}

	@Override
	public void deleteProject(long projectId) {
		String sql = "DELETE FROM projects WHERE project_id = ?";
		jdbcTemplate.update(sql, projectId);
		
	}
	
	

}
