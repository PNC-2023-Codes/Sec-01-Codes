package com.douglashdezt.libraryREST.services;

import java.util.List;

import com.douglashdezt.libraryREST.models.entities.Book;

public interface BookService {
	// findAll, findOneById, save, delete
	void save(Book book);
	void delete(String isbn);
	Book findOneById(String isbn);
	List<Book> findAll();
}
