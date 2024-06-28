package com.project.movie.entities;

import com.project.movie.enums.SeatType;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "show_seats")
public class ShowSeat {

    @Id
    private Integer id;
  
    private String seatNo;

    private SeatType seatType;

    private Integer price;
    
    private Boolean isAvailable;
    
    private Boolean isFoodContains;

    @DBRef
    private Show show;
}
