package com.douglashdezt.library.services;

import com.douglashdezt.library.models.dtos.UserRegisterDTO;
import com.douglashdezt.library.models.entities.User;

public interface UserService {
	User findOneByIdentifier(String identifier);
	User findOneByUsernameOrEmail(String username, String email);
	void register(UserRegisterDTO info) throws Exception;
	Boolean comparePassword(String toCompare, String current);
}
