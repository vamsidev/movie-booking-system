package com.project.movie.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shows")
public class Show {

    @Id
    private String showId;

    private Date time;

    private Date date;

    @DBRef
    private Movie movie;

    @DBRef
    private Theater theater;

    @DBRef
    private List<ShowSeat> showSeatList = new ArrayList<>();

    @DBRef
    private List<Ticket> ticketList = new ArrayList<>();
}
