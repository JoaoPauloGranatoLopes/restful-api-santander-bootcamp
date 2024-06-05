package com.santander.santander_2024.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.santander_2024.domain.model.User;
import com.santander.santander_2024.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This Account number already exists.");
		}
		return userRepository.save(userToCreate);
	}

}