	package com.infy.ems.dto;
	
	import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
	
	public class EmployeeRequestDTO {
		
		@NotBlank (message = "Name is required")
	    private String name;
		
		@Email(message = "Email format is invalid ")
		@NotBlank (message =  "Email is required ")
		private String email;
		
		@NotBlank(message = "Please add department") 
		private String department;
		
		public String getDepartment() {
			return department;
		}
	
	
		public void setDepartment(String department) {
			this.department = department;
		}
	
	
		@NotNull(message =  " Salary is required ")
		@Positive
		private Double salary;
	
	
		
	
		public String getName() {
			return name;
		}
	
	
		public void setName(String name) {
			this.name = name;
		}
	
	
		public String getEmail() {
			return email;
		}
	
	
		public void setEmail(String email) {
			this.email = email;
		}
	
	
		public Double getSalary() {
			return salary;
		}
	
	
		public void setSalary(Double salary) {
			this.salary = salary;
		}
	
	
		
		
		
	}
