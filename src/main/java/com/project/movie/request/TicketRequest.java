package com.project.movie.request;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class TicketRequest {
    private ObjectId showId;
    private ObjectId userId;
    private List<String> requestSeats;
}
