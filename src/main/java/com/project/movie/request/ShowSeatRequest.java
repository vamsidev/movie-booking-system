package com.project.movie.request;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class ShowSeatRequest {
    private ObjectId showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
}
