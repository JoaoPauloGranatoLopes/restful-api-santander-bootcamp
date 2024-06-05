package com.santander.santander_2024.service;

import com.santander.santander_2024.domain.model.User;

public interface UserService {
	
	User findById(Long id);
	User create(User userToCreate);
	

}
