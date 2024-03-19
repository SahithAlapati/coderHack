package com.crio.coderHack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crio.coderHack.model.User;


@Repository
public interface UserRepository extends MongoRepository<User,String> {
   // List<User> findAll();
   // Optional<User> findById(String id);
}
