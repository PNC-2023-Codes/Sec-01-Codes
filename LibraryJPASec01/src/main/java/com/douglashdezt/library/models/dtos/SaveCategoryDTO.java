package com.douglashdezt.library.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveCategoryDTO {

	@NotEmpty(message = "Code is required")
	@Pattern(regexp = "^[0-9A-Z]{4}$", message = "Code must have exactly 4 alphanumeric chars")
	private String code;
	
	@NotEmpty(message = "Name is required")
	@Size(min = 5, message = "Name size is 5 chars")
	private String name;
	
}
