package com.infy.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ems.entity.Employee;
import com.infy.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   
	private EmployeeRepository theEmployeeRepository;

	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.theEmployeeRepository = theEmployeeRepository;
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return theEmployeeRepository.findAll();
	}


	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return theEmployeeRepository.save(employee);
	}


	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return theEmployeeRepository.findById(id).orElse(null);
	}


	@Override
	public Employee updateEmployee(Long id, Employee employee) {
         employee.setEmployeeId(id);
		return theEmployeeRepository.save(employee);
	}


	@Override
	public void deleteEmployee(Long id) {

        theEmployeeRepository.deleteById(id);
	}
	
	
	
	
}
