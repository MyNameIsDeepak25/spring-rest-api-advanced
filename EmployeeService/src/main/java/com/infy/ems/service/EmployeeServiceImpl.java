package com.infy.ems.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.infy.ems.client.LeaveClient;
import com.infy.ems.dto.EmployeePatchDTO;
import com.infy.ems.dto.EmployeeRequestDTO;
import com.infy.ems.dto.LeaveResponseDTO;
import com.infy.ems.entity.Employee;
import com.infy.ems.exception.EmployeeNotFoundException;
import com.infy.ems.repository.EmployeeRepository;
import com.infy.ems.service.dto.EmployeeWithLeavesResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   
	private static final Logger log =
            LoggerFactory.getLogger(EmployeeService.class);
	
	private EmployeeRepository theEmployeeRepository;
	private final LeaveClient leaveClient;


	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository, LeaveClient leaveClient) {
		this.theEmployeeRepository = theEmployeeRepository;
		this.leaveClient = leaveClient;
	}


	


	@Override
	public Employee createEmployee(EmployeeRequestDTO dto) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setName(dto.getName());
		emp.setEmail(dto.getEmail());
		emp.setDepartment(dto.getDepartment());
		emp.setSalary(dto.getSalary());
		return theEmployeeRepository.save(emp);
	}


	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		log.info("Fetching employee details from database for id={}", id);
		return theEmployeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found with id: " + id));
	}


	@Override
	public Employee updateEmployee(Long id, EmployeeRequestDTO dto) {
         Employee existing=getEmployeeById(id);
         existing.setName(dto.getName());
         existing.setDepartment(dto.getDepartment());
         existing.setSalary(dto.getSalary());
         return theEmployeeRepository.save(existing);
	}


	@Override
	public Employee patchEmployee(Long id, EmployeePatchDTO dto) {
		// TODO Auto-generated method stub
		Employee existing=getEmployeeById(id);
		

		   if (dto.getName() != null) {
		       existing.setName(dto.getName());
		   }

		   if (dto.getEmail() != null) {
		       existing.setEmail(dto.getEmail());
		   }

		   if (dto.getDepartment() != null) {
		       existing.setDepartment(dto.getDepartment());
		   }

		   if (dto.getSalary() != null) {
		       existing.setSalary(dto.getSalary());
		   }

		   return theEmployeeRepository.save(existing);

		
	}
	 public EmployeeWithLeavesResponse getEmployeeWithLeaves(Long id) {

	        Employee employee = theEmployeeRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Employee not found"));

	        List<LeaveResponseDTO> leaves = leaveClient.getLeaves(id);

	        return new EmployeeWithLeavesResponse(employee, leaves);
	    }
	@Override
	public void deleteEmployee(Long id) {

		Employee emp=theEmployeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found with id: " + id));
        theEmployeeRepository.delete(emp);
	}


	@Override
	public Page<Employee> findAll(int page, int size) {
		// TODO Auto-generated method stub
      Pageable pageable = PageRequest.of(page, size);
      return theEmployeeRepository.findAll(pageable);

	}





	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		
		List<Employee> employees = theEmployeeRepository.findByNameContainingIgnoreCase(name);
		return employees;
	}


	
	
	
	
	
}
