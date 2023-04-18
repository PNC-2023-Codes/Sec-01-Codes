package com.douglashdezt.sec01.library.services;

import com.douglashdezt.sec01.library.models.entities.Book;
import java.util.List;

public interface BookService {
	// Save, delete, getOneById, getAll
	void save(Book book);
	void delete(String isbn);
	Book findOneById(String isbn);
	List<Book> findAll();
}
