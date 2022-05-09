package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.model.Concert;

@Repository("concertRepository")
public interface ConcertRepository extends JpaRepository<Concert, String>{
	
	public List<Concert> findAll();
	public List<Concert> findByArtist(String artist);
	public <S extends Concert> S save(Concert concert);
	public void delete(Concert concert);
	<S extends Concert> List<S> saveAll(Iterable<S> entities);
}
