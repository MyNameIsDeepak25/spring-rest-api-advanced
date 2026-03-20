package com.infy.ems.service;

import java.util.List;
import java.util.Optional;

import com.infy.ems.dto.EmployeePatchDTO;
import com.infy.ems.dto.EmployeeRequestDTO;
import com.infy.ems.entity.Employee;
import com.infy.ems.service.dto.EmployeeWithLeavesResponse;

public interface EmployeeService {
	
	public List<Employee> findAll();
	 public Employee createEmployee(EmployeeRequestDTO dto);
	 public Employee getEmployeeById(Long id) ;
	 public Employee updateEmployee(Long id, EmployeeRequestDTO dto);
	 public Employee patchEmployee(Long id, EmployeePatchDTO dto);
	 public void deleteEmployee(Long id); 
	 public EmployeeWithLeavesResponse getEmployeeWithLeaves(Long id);

}
