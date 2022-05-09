package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Ticket;

@Repository("ticketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	List<Ticket> findAll();
	<S extends Ticket> S save(S entity);
}

