package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Venue;

@Repository("venueRepository")
public interface VenueRepository extends JpaRepository<Venue, String>{
	
	public List<Venue> findAll();
	public List<Venue> findByMonth(String month);
	public <S extends Venue> S save(Venue concert);
	public void delete(Venue id);
	
}
