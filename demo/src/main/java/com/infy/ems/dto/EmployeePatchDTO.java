package com.infy.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmployeePatchDTO {
	  private String name;
	   @Email
	   private String email;
	   private String department;
	   
	   @Positive
	   @NotNull
	   private Double salary;
	public EmployeePatchDTO(String name, String email, String department, Double salary) {
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	   
	   


}
