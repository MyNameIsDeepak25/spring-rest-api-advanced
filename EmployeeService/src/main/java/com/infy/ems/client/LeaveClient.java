package com.infy.ems.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.infy.ems.dto.LeaveResponseDTO;

@FeignClient(name = "leave-service" , url = "http://localhost:8081")
public interface LeaveClient {
    
	@GetMapping ("/leave/employee/{employeeId}")
	List<LeaveResponseDTO>  getLeaves(@RequestParam("employeeId")  Long employeeId);
		
}
