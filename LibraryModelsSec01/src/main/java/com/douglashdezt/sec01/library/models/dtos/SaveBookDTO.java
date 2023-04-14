package com.douglashdezt.sec01.library.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveBookDTO {
	@NotEmpty(message = "ISBN vacio!")
	@Size(min =10, max = 10, message = "Exactamente 10 caracteres")
	private String isbn;
	
	@NotEmpty(message = "Titulo vacio!")
	private String title;
	
	@NotEmpty(message = "dueno vacio")
	@Email(message = "Formato de dueño incorrecto")
	private String owner;
}
