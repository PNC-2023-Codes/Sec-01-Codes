package com.douglashdezt.sec01.library.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveBookDTO {
	private String isbn;
	private String title;
	private String owner;
}
