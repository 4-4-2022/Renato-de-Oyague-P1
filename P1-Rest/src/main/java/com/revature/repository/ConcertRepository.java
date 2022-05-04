package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Concert;

@Repository("concertRepository")
public interface ConcertRepository extends JpaRepository<Concert, String>{
	
	public List<Concert> findAll();
	public List<Concert> findByArtist(String artist);
	public List<Concert> findAllByPriceBetween(int price1, int price2);
	public <S extends Concert> S save(Concert ticket);
	public void delete(Concert ticket);
}
