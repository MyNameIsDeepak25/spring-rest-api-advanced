package com.infy.ems.exception;

import java.time.LocalDate;

public class ErrorResponse {
	
	private String message;
	private int status;
	private LocalDate timeStamp;
	public ErrorResponse(String message, int status, LocalDate timeStamp) {
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
