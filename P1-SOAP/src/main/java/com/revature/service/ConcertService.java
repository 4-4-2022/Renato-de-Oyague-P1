package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.revature.model.Concert;

@WebService
public interface ConcertService {
	
	public List<Concert> findAll();
	public List<Concert> findByArtist(String artist);
	public void save(Concert concert);
	public void saveAll(Map<String, Integer> tickets);
	public void receiveMessage(String message);
}
