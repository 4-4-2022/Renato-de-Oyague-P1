package com.revature.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Concert;
import com.revature.repository.ConcertRepository;

@Service("ConcertService")
public class ConcertService {
	
	private ConcertRepository concertRepository;
	
	@Autowired
	public void setConcertRepository(ConcertRepository concertRepository) {
		this.concertRepository = concertRepository;
	}
	
	public List<Concert> findAll(){
		return this.concertRepository.findAll();
	}
	
	public List<Concert> findByArtist(String artist) {
		return this.concertRepository.findByArtist(artist);
	}
	
	public List<Concert> findAllByPriceBetween(int price1, int price2){
		return this.concertRepository.findAllByPriceBetween(price1, price2);
	}
	
	public void save(Concert ticket) {
		this.concertRepository.save(ticket);
	}
	
	public void delete(Concert ticket) {
		this.concertRepository.delete(ticket);
	}
}
