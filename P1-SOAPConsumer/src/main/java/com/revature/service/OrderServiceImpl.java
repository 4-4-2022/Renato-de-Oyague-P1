package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Order;
import com.revature.model.OrderTicketKey;
import com.revature.model.Ticket;
import com.revature.repository.OrderRepository;
import com.revature.repository.TicketRepository;

@WebService(endpointInterface = "com.revature.service.OrderService", name = "order")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private OrderRepository orderRepository;
	private TicketRepository ticketRepository;
	
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Autowired
	public void setTicketRepository(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Override
	@WebMethod
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return this.orderRepository.findAll();
	}
	
	@Override
	@WebMethod
	public List<Ticket> findAllTicket() {
		// TODO Auto-generated method stub
		return this.ticketRepository.findAll();
	}
	
	public void save(Order order, Map<Integer, Integer> tickets) {
		Order savedOrder = this.orderRepository.save(order);
		for (int id : tickets.keySet()) {
			for(int cid : tickets.keySet()) {
			OrderTicketKey orderTicketKey = new OrderTicketKey(savedOrder, id, cid);
			Ticket item = new Ticket(orderTicketKey, tickets.get(id));
			this.ticketRepository.save(item);
			}
		}
		this.sendQuantityUpdates(tickets);
	}
	
	public void sendQuantityUpdates(Map<Integer, Integer> tickets) {
		final String URI = "/concert-service?wsdl";
		StringBuilder entries = new StringBuilder();
		for(int id : tickets.keySet()) {
			entries.append("<entry> <key>" 
					+ id + "</key><value>" 
					+ tickets.get(id) 
					+ "</value></entry>");
		}
		final String SOAP_MESSAGE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.revature.com/\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <ser:saveAll>\r\n"
				+ "         <arg0>\r\n"
				+ 				entries
				+ "         </arg0>\r\n"
				+ "      </ser:saveAll>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, headers);
		this.restTemplate.postForLocation(URI, request);
	}

	@Override
	public String contactVenueService(String message) {
		
		final String URI = "/concert-service?wsdl";
		final String SOAP_MESSAGE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.revature.com/\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <ser:receiveMessage>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <arg0>" + message + "</arg0>\r\n"
				+ "      </ser:receiveMessage>\r\n"
				+ "</soapenv:Envelope>";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, header);
		this.restTemplate.postForLocation(URI, request);
		return message;
	}



}
