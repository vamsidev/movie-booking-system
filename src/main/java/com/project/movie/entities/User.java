package com.project.movie.entities;

import com.project.movie.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String address;

    private Gender gender;

    private String mobileNo;

    private String emailId;
    
    private String password;

	private String roles;
    @DBRef
    private List<Ticket> ticketList = new ArrayList<>();
}
