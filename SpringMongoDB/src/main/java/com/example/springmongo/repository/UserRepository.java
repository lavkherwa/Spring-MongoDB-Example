package com.example.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springmongo.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
