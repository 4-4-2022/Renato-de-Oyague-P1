package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.revature.model.Order;
import com.revature.model.Ticket;

@WebService
public interface OrderService {
	
	List<Order> findAll();
	List<Ticket> findAllTicket();
	void save(Order order, Map<Integer, Integer> tickets);
	String contactVenueService(String message);
}
