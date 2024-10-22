package com.emp.empManagementSys.service;

import com.emp.empManagementSys.dto.DepartmentsRequest;
import com.emp.empManagementSys.model.Departments;

public interface DepartmentsService {
	
	void addDepartment(DepartmentsRequest request);
	int updateDepartmentName(long id, String name);

}
