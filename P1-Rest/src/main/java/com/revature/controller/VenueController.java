package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Concert;
import com.revature.model.Venue;
import com.revature.service.ConcertService;
import com.revature.service.VenueService;

@RestController("venueController")
@RequestMapping("/venue")
public class VenueController {
	
	private ConcertService concertService;
	private VenueService venueService;
	
	@Autowired
	public void setTicketService(ConcertService ticketService) {
		this.concertService = ticketService;
	}
	
	@Autowired
	public void setVenueService(VenueService venueService) {
		this.venueService = venueService;
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venue>> findAll(){
		ResponseEntity<List<Venue>> httpResponse = new ResponseEntity<>(this.venueService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	
	@GetMapping("/{month}")
	public List<Venue> findByMonth(@PathVariable String month) {
		return this.venueService.findByMonth(month);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Venue concert) {
		this.venueService.save(concert);
	}
	
	@DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody Venue id) {
		this.venueService.delete(id);
	}
	
	@GetMapping(value = "/concert/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Concert>> finAll(){
		ResponseEntity<List<Concert>> httpResponse = new ResponseEntity<>(this.concertService.findAll(), HttpStatus.OK);
		return httpResponse;
	}
	
	@PostMapping(value = "/concert/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Concert ticket) {
		this.concertService.save(ticket);
	}
	
	@DeleteMapping(value = "/concert/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody Concert ticket) {
		this.concertService.delete(ticket);
	}
	
	@GetMapping("/concert/{artist}")
	public List<Concert> findByArtist(@PathVariable String artist) {
		return this.concertService.findByArtist(artist);
	}
	
	@GetMapping("/concert/price")
	public List<Concert> findAllByPriceBetween(@RequestParam int price1, @RequestParam int price2){
		return this.concertService.findAllByPriceBetween(price1, price2);
	}
}
