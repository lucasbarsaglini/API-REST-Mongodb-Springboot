package com.example.APIMongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.APIMongodb.domain.Post;
import com.example.APIMongodb.domain.User;
import com.example.APIMongodb.dto.AuthorDTO;
import com.example.APIMongodb.repository.PostRepository;
import com.example.APIMongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria", "maria@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria));
		
		Post post = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post));
	}

	
}
