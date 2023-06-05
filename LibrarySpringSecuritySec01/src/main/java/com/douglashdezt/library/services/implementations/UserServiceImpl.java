package com.douglashdezt.library.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.douglashdezt.library.models.dtos.UserRegisterDTO;
import com.douglashdezt.library.models.entities.User;
import com.douglashdezt.library.repositories.UserRepository;
import com.douglashdezt.library.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOneByIdentifier(String identifier) {
		return userRepository.findOneByUsernameOrEmail(identifier, identifier);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void register(UserRegisterDTO info) throws Exception {
		User newUser = new User();
		
		newUser.setUsername(info.getUsername());
		newUser.setEmail(info.getEmail());
		newUser.setPassword(
					passwordEncoder.encode(info.getPassword())
				);
		
		userRepository.save(newUser);
	}

	@Override
	public Boolean comparePassword(String toCompare, String current) {
		return passwordEncoder.matches(toCompare, current);
	}

	@Override
	public User findOneByUsernameOrEmail(String username, String email) {
		return userRepository.findOneByUsernameOrEmail(username, email);
	}

}
