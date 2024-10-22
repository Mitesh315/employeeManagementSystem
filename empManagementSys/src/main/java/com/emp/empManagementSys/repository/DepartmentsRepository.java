package com.emp.empManagementSys.repository;

import com.emp.empManagementSys.dto.DepartmentsRequest;

public interface DepartmentsRepository {
	
	void addDepartment(DepartmentsRequest request);
	int updateDepartmentName(long id, String name);

}
