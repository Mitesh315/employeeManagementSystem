package com.emp.empManagementSys.service;

import java.util.List;
import java.util.Optional;

import com.emp.empManagementSys.dto.EmployeesRequest;
import com.emp.empManagementSys.model.Employees;

public interface EmployeesService {

	void addEmployee(EmployeesRequest request);
	int updateEmployeeEmail(long id, String email);
	List<Employees> findAll();
	Optional<Employees> findById(long id);
	void deleteEmployee(long id);
	void updateDepartment(long departmentId, long id);
	List<Employees> getSortedList();
	List<Employees> getPaginatedList(int page, int limit);
}
