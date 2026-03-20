package com.infy.leave_service;

import org.springframework.stereotype.Service;

import com.infy.leave_service.entity.LeaveRequest;
import com.infy.leave_service.entity.LeaveStatus;
import com.infy.leave_service.repository.LeaveRepository;

import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public LeaveRequest applyLeave(LeaveRequest request) {
        request.setStatus(LeaveStatus.PENDING);
        return leaveRepository.save(request);
    }

    public List<LeaveRequest> getLeaveByEmployee(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }
}