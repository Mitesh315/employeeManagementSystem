package com.emp.empManagementSys.repository;

import java.util.List;
import java.util.Optional;

import com.emp.empManagementSys.dto.DepartmentsRequest;
import com.emp.empManagementSys.model.Departments;

public interface DepartmentsRepository {

	void addDepartment(DepartmentsRequest request);

	int updateDepartmentName(long id, String name);

	List<Departments> findAll();

	Optional<Departments> findById(long departmentId);

	void deleteDepartment(long departmentId);

}
