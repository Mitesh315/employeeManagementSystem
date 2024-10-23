package com.emp.empManagementSys.repository;

import java.util.List;

public interface EmployeeProjectRepository {
	
	void setProjectToMultipleEmployee(long projectId, List<Long> ids);
	void setMultipleProjectToEmployee(long id, List<Long> projectIds);
}
