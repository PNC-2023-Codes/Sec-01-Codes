package com.douglashdezt.sec01.library.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	private String isbn;
	private String title;
}
