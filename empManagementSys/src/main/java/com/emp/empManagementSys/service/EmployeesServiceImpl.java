package com.emp.empManagementSys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.empManagementSys.dto.EmployeesRequest;
import com.emp.empManagementSys.model.Employees;
import com.emp.empManagementSys.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService{
	
	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public void addEmployee(EmployeesRequest request) {
		employeesRepository.addEmployee(request);
	}

	@Override
	public int updateEmployeeEmail(long id, String email) {
		return employeesRepository.updateEmployeeEmail(id, email);
	}

	@Override
	public List<Employees> findAll() {
		return employeesRepository.findAll();
	}

	@Override
	public Optional<Employees> findById(long id) {
		return employeesRepository.findById(id);
	}

	@Override
	public void deleteEmployee(long id) {
		employeesRepository.deleteEmployee(id);
	}
	
	
	

}
