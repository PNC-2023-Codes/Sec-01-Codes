package com.douglashdezt.library.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class RequestErrorHandler {
	public Map<String, List<String>> mapErrors(List<FieldError> fieldErrors) {
		Map<String, List<String>> mappedErrors = new HashMap<>();
    	fieldErrors.stream()
    		.forEach(error -> {
    			String key = error.getField();
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
