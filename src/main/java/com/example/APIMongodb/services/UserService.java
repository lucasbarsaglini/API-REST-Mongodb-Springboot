package com.example.APIMongodb.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.APIMongodb.domain.User;
import com.example.APIMongodb.dto.UserDTO;
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
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = userRepository.findOne(obj);
		updateData(newObj, obj);
		return userRepository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
