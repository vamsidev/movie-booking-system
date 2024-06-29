package com.project.movie.controllers;

import com.project.movie.entities.Ticket;
import com.project.movie.entities.User;
import com.project.movie.services.MongoTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.movie.request.TicketRequest;
import com.project.movie.response.TicketResponse;
import com.project.movie.services.TicketService;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private MongoTemplateService mongoTemplateService;

	@PostMapping("/book")
	public ResponseEntity<Object> ticketBooking(@RequestBody TicketRequest ticketRequest) {
		try {
			TicketResponse result = ticketService.ticketBooking(ticketRequest);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/price/{price}")
	public ResponseEntity<List<Ticket>> findUsersByEmailDomainWithAggregation(@PathVariable String price){
		List<Ticket> tickets = mongoTemplateService.findTicketPriceWithAggregation(price);
		return ResponseEntity.ok(tickets);
	}
}
