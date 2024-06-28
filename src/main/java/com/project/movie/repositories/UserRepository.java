package com.project.movie.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.movie.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{ emailId : ?0 }")
    Optional<User> findByEmailId(String emailId);
}
