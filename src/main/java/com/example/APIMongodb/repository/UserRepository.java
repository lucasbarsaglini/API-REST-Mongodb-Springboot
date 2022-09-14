package com.example.APIMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.APIMongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
