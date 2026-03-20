package com.infy.ems.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long employeeId;

	   private String name;
	   private String email;
	   private String department;
	   private double salary;
	   
	   @OneToOne
	   @JoinColumn(name = "emp_address_id")
	   private Address address;
	   
	   
	   
	   
	   
	public Employee() {
	}
	public Employee( String name, String email, String department, double salary, Address address) {
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.address=address;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", department="
				+ department + ", salary=" + salary + ", address=" + address + "]";
	}
	
	   
	   
 
	

}
