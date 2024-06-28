package com.project.movie.repositories;

import org.bson.types.ObjectId;

import com.project.movie.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, ObjectId> {
}
