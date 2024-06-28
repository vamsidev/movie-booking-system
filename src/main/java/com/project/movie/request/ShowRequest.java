package com.project.movie.request;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
public class ShowRequest {

    private Date showStartTime;
    private Date showDate;
    private ObjectId theaterId;
    private ObjectId movieId;
}
