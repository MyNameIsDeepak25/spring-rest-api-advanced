package com.infy.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ems.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
  List<Employee> findByNameContainingIgnoreCase(String name);
}
