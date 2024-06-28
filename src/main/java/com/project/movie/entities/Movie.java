package com.project.movie.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.movie.enums.Genre;
import com.project.movie.enums.Language;

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
@Document(collection = "movies")
public class Movie {

    @Id
    private ObjectId id;

    private String movieName;

    private Integer duration;

    private Double rating;

    private Date releaseDate;

    private Genre genre;

    private Language language;

    @DBRef
    private List<Show> shows = new ArrayList<>();
}
