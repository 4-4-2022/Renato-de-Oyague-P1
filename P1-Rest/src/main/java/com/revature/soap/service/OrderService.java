package com.revature.soap.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.revature.dto.Order;
import com.revature.dto.Ticket;

@WebService(serviceName = "order-service", targetNamespace = "http://service.revature.com/")
@Component
public interface OrderService {

	@WebMethod
	public List<Order> findAll();
	List<Ticket> findAllTicket();
}
