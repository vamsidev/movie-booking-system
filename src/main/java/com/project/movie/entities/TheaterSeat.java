package com.project.movie.entities;

import com.project.movie.enums.SeatType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "theater_seats")
public class TheaterSeat {

    @Id
    private Integer id;

    private String seatNo;

    private SeatType seatType;

    @DBRef
    private Theater theater;
}









