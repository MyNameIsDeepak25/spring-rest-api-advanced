package com.infy.ems.service.dto;

import java.util.List;

import com.infy.ems.dto.LeaveResponseDTO;
import com.infy.ems.entity.Employee;

public class EmployeeWithLeavesResponse {
    private Employee employee;
    private List<LeaveResponseDTO> leaves;

    public EmployeeWithLeavesResponse(Employee employee,
                                      List<LeaveResponseDTO> leaves) {
        this.employee = employee;
        this.leaves = leaves;
    }

	public Employee getEmployee() {
		return employee;
	}

	public List<LeaveResponseDTO> getLeaves() {
		return leaves;
	}
    

}
