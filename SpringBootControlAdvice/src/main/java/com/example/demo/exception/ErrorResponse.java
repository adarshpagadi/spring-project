package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorResponse {
	
	private LocalDateTime timeStamp;
	private String message;	
	private List<String> fieldErrors = new ArrayList<>();
	public ErrorResponse(LocalDateTime now, String message2, Object object) {
		
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}	
	public List<String> getFieldErrors(){
		return fieldErrors;
	}
}
