package com.douglashdezt.libraryREST.services;

import com.douglashdezt.libraryREST.models.dtos.RegisterDTO;
import com.douglashdezt.libraryREST.models.entities.User;

public interface UserService {
	// verifyPassword, register, findOneById
	void register(RegisterDTO info);
	User findOneById(String id);
}
