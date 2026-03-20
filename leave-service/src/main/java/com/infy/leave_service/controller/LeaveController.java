package com.infy.leave_service.controller;

import org.springframework.web.bind.annotation.*;

import com.infy.leave_service.LeaveService;
import com.infy.leave_service.entity.LeaveRequest;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/apply")
    public LeaveRequest applyLeave(@RequestBody LeaveRequest request) {
        return leaveService.applyLeave(request);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeaves(@PathVariable Long employeeId) {
        return leaveService.getLeaveByEmployee(employeeId);
    }
}
