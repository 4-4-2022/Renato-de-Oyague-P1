package com.revature.dto;

public class TicketPurchaseDto {
	
	private int id;
	private int quantity;
	
	public TicketPurchaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketPurchaseDto(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
