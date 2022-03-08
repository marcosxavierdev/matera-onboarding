package com.matera.onboarding.business.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardMessageException {
	
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String path;

}
