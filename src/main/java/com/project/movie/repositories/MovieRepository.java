package com.project.movie.repositories;

import org.bson.types.ObjectId;

import com.project.movie.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
	@Query("{ movieName : ?0 }")
	Movie findByMovieName(String name);
}