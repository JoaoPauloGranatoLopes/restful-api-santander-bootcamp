package com.santander.santander_2024.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.santander.santander_2024.domain.model.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByAccountNumber(String accountNumber);


}