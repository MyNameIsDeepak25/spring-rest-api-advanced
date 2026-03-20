package com.infy.leave_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.leave_service.entity.LeaveRequest;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long>{
          List<LeaveRequest>  findByEmployeeId(long employeeId);
}
