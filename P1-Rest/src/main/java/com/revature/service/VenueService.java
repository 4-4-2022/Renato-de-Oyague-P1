package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Venue;
import com.revature.repository.VenueRepository;

@Service("VenueService")
public class VenueService {
	
	private VenueRepository venueRepository;
	
	@Autowired
	public void setVenueRepository(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}
	
	public List<Venue> findAll(){
		return this.venueRepository.findAll();
	}
	
	public List<Venue> findByMonth(String month) {
		return this.venueRepository.findByMonth(month);
	}
	
	public void save(Venue concert) {
		this.venueRepository.save(concert);
	}
}
