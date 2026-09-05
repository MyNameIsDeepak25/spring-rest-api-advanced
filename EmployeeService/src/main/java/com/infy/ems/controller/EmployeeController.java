package com.infy.ems.controller;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;import com.infy.ems.dto.EmployeePatchDTO;
import com.infy.ems.dto.EmployeeRequestDTO;
import com.infy.ems.entity.Employee;
import com.infy.ems.response.ApiResponse;
import com.infy.ems.service.EmployeeService;
import com.infy.ems.service.dto.EmployeeWithLeavesResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService theEmployeeService;
	
	private static final Logger log= org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		this.theEmployeeService = theEmployeeService;
	}
	
	@PostMapping("/employees")
	   public ResponseEntity<ApiResponse<Employee>> createEmployee( @Valid @RequestBody EmployeeRequestDTO dto) {
		Employee emp=theEmployeeService.createEmployee(dto);
		ApiResponse<Employee> response=new ApiResponse<Employee>("SUCCESS", 
				"Employee created successfully", 
				emp);
	       return new ResponseEntity<>(response,HttpStatus.CREATED);
	   }

	@GetMapping("/employees")
    public Page<Employee> findAll(@RequestParam(defaultValue = "0") int page,
    		
    		@RequestParam(defaultValue = "5") int size){
		return theEmployeeService.findAll(page, size);
		
	}
	
	
	  @GetMapping("/employees/{id}")
	   public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable Long id) {
		  Employee emp=theEmployeeService.getEmployeeById(id);
		  ApiResponse<Employee> response=new ApiResponse<>("SUCCESS", "Employee fetched successfully ", emp);
		  log.info("Received request to fetch employee with id={}", id);
	       return new ResponseEntity<>(response,HttpStatus.FOUND);
	   }

	   @PutMapping("/employees/{id}")
	   public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable Long id,
	                                   @Valid @RequestBody EmployeeRequestDTO dto) {
		   Employee updated=theEmployeeService.updateEmployee(id, dto);
		   ApiResponse<Employee> response=new ApiResponse<>("SUCCESS", "Employee updated successfully", updated);
	       return ResponseEntity.ok(response);
	   }

 
	   @PatchMapping("/employees/{id}")
	   public ResponseEntity<ApiResponse<Employee>> patchEmployee(@PathVariable Long id, @Valid @RequestBody EmployeePatchDTO dto){
		   Employee updated=theEmployeeService.patchEmployee(id, dto);
		   ApiResponse<Employee> response= new ApiResponse<>("SUCCESS", "Employee partially updated ", updated);
		   return ResponseEntity.ok(response);
	   }
	   
	   
	   @DeleteMapping("/employees/{id}")
	   public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable Long id) {
	       theEmployeeService.deleteEmployee(id);
	       ApiResponse<Void> response =new ApiResponse<>("SUCCESS", "Employee deleted successfully", null);
	       return ResponseEntity.ok(response);
	   }
	   
	   @GetMapping("/employees/search")
	   public List<Employee> findByEmployeeName(@RequestParam String name){
		   return theEmployeeService.findByName(name);
		   
	   }
	   @GetMapping("employees/{id}/leavedetails")
	   public EmployeeWithLeavesResponse getEmployeeDetails(@PathVariable Long id) {
	       return theEmployeeService.getEmployeeWithLeaves(id);
	   }

}
