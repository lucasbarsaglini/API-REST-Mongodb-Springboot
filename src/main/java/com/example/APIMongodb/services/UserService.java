package com.example.APIMongodb.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.APIMongodb.domain.User;
import com.example.APIMongodb.repository.UserRepository;
import com.example.APIMongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserRepository userRepository; 
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
