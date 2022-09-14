package com.example.APIMongodb.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.APIMongodb.domain.User;
import com.example.APIMongodb.repository.UserRepository;

@Service
public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserRepository userRepository; 
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
