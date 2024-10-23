package com.emp.empManagementSys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.empManagementSys.dto.DepartmentsRequest;
import com.emp.empManagementSys.model.Departments;
import com.emp.empManagementSys.repository.DepartmentsRepository;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Override
	public void addDepartment(DepartmentsRequest request) {
		departmentsRepository.addDepartment(request);
	}

	@Override
	public int updateDepartmentName(long id, String name) {
		return departmentsRepository.updateDepartmentName(id, name);
	}

	@Override
	public List<Departments> findAll() {
		return departmentsRepository.findAll();
	}

	@Override
	public Optional<Departments> findById(long departmentId) {
		return departmentsRepository.findById(departmentId);
	}

	@Override
	public void deleteDepartment(long departmentId) {
		departmentsRepository.deleteDepartment(departmentId);
	}
	
	

}
