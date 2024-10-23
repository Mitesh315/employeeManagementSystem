package com.emp.empManagementSys.service;

import java.util.List;

public interface EmployeeProjectService {

	void setProjectToMultipleEmployee(long projectId, List<Long> ids);
	void setMultipleProjectToEmployee(long id, List<Long> projectIds);
}
