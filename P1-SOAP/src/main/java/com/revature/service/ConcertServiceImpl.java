package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Concert;
import com.revature.repository.ConcertRepository;

@WebService(endpointInterface = "com.revature.service.ConcertService", name = "concert")
public class ConcertServiceImpl implements ConcertService {
	
	private ConcertRepository concertRepository;
	
	public ConcertServiceImpl() {}
	
	public ConcertServiceImpl(ConcertRepository concertRepository) {
		this.concertRepository = concertRepository;
	}
	
	@Autowired
	public void setVenueRepository(ConcertRepository concertRepository) {
		this.concertRepository = concertRepository;
	}

	@WebMethod
	public List<Concert> findAll() {
		return this.concertRepository.findAll();
	}
	
	@WebMethod
	public List<Concert> findByArtist(String artist){
		return this.concertRepository.findByArtist(artist);
	}
	
	@WebMethod
	public void save(Concert concert) {
		this.concertRepository.save(concert);
	}

	@Override
	@WebMethod
	public void receiveMessage(String message) {
		System.out.println(message);
		
	}

	@Override
	public void saveAll(Map<String, Integer> tickets) {
		List<Concert> cupcakesToUpdate = this.concertRepository.findAllById(tickets.keySet());
		System.out.println(cupcakesToUpdate);
		for(String artist : tickets.keySet()) {
			for(Concert venue : cupcakesToUpdate) {
				if(venue.getArtist().equals(artist)) {
					venue.setStock(venue.getStock() - tickets.get(artist));
				}
			}
		}
		this.concertRepository.saveAll(cupcakesToUpdate);
	}

}
