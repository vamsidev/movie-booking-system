package com.project.movie.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.movie.entities.Show;

public interface ShowRepository extends MongoRepository<Show, ObjectId> {

}
