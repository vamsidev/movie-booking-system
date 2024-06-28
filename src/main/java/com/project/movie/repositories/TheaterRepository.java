package com.project.movie.repositories;

import org.bson.types.ObjectId;

import com.project.movie.entities.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TheaterRepository extends MongoRepository<Theater, ObjectId> {
    @Query("{ address : ?0 }")
    Theater findByAddress(String address);
}
