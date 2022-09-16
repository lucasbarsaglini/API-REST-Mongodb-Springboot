package com.example.APIMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.APIMongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
