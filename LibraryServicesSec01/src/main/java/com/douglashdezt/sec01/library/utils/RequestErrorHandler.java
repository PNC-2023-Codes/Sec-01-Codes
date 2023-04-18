package com.douglashdezt.sec01.library.utils;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RequestErrorHandler {
	public Map<String, List<String>> mapErrors(List<FieldError> fieldErrors) {
		Map<String, List<String>> mappedErrors = new HashMap<>();
    	fieldErrors.stream()
    		.forEach(error -> {
    			String key = error.getField() + "_errors";
    			List<String> errors = mappedErrors.get(key);
    			
    			if (errors == null) {
    				errors = new ArrayList<>();
    			}
    			
    			errors.add(error.getDefaultMessage());
    			
    			mappedErrors.put(key, errors);
    		});
    	return mappedErrors;
	}
}
