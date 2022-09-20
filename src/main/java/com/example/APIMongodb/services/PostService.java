package com.example.APIMongodb.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.APIMongodb.domain.Post;
import com.example.APIMongodb.repository.PostRepository;
import com.example.APIMongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PostRepository postRepository; 
	
	public Post findById(String id) {
		Post user = postRepository.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findBysearchTitle(text);
	}
}