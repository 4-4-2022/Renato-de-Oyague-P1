package com.revature.dto;

public class Ticket {

	OrderTicketKey key;
	private int quantity;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(OrderTicketKey key, int quantity) {
		super();
		this.key = key;
		this.quantity = quantity;
	}

	public OrderTicketKey getKey() {
		return key;
	}

	public void setKey(OrderTicketKey key) {
		this.key = key;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item key=" + key + ", quantity = " + quantity;
	}

}
