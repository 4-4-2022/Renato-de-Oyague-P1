package com.revature.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Concert;

@RestController
public class ConcertTicketController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/concert")
	public Concert[]  getConcert(@PathParam(value="artist") String artist) {
		ResponseEntity<Concert[]> concert = restTemplate.getForEntity("http://localhost:8080/venue/concert/" + artist, Concert[].class);
		return concert.getBody();
	}
	
	@GetMapping("/concert/all")
	public Concert[]  getConcertAll() {
		ResponseEntity<Concert[]> concert = restTemplate.getForEntity("http://localhost:8080/venue/concert/all", Concert[].class);
		return concert.getBody();
	}
}
