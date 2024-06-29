package com.project.movie.services;

import com.project.movie.entities.Ticket;
import com.project.movie.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoTemplateService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> findUsersByEmailDomainWithAggregation(String domain) {
        MatchOperation matchOperation = Aggregation.match(Criteria.where("emailId").regex(".*@" + domain + ".*"));
        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
        return mongoTemplate.aggregate(aggregation, "users", User.class).getMappedResults();
    }

    public List<Ticket> findTicketPriceWithAggregation(String price) {
        List<AggregationOperation> aggregationOperations = new ArrayList<>();
        aggregationOperations.add(Aggregation.match(Criteria.where("totalTicketsPrice").gte(Integer.valueOf(price))));
        aggregationOperations.add(Aggregation.sort(Sort.Direction.DESC, "totalTicketsPrice"));
        Aggregation aggregation = Aggregation.newAggregation(aggregationOperations);
        return mongoTemplate.aggregate(aggregation, "tickets", Ticket.class).getMappedResults();
    }
}
