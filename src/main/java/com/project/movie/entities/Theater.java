package com.project.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "theaters")
public class Theater {

    @Id
    private String id;

    private String name;

    private String address;

    @DBRef
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

    @DBRef
    private List<Show> showList = new ArrayList<>();
}
