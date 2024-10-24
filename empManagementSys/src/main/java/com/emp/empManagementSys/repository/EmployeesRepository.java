package com.emp.empManagementSys.repository;

import java.util.List;
import java.util.Optional;

import com.emp.empManagementSys.dto.EmployeesRequest;
import com.emp.empManagementSys.model.Employees;

public interface EmployeesRepository {

	void addEmployee(EmployeesRequest request);
	int updateEmployeeEmail(long id, String email);
	List<Employees> findAll();
	Optional<Employees> findById(long id);
	void deleteEmployee(long id);
	void updateDepartment(long id, long departmentId);
	List<Employees> getSortedList();
	List<Employees> getPaginatedList(int page, int limit);

}
