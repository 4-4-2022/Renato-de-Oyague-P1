package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class OrderTicketKey implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Order order_id;
	@Column(name = "venue_id")
	private int venue_id;
	@Column(name = "concert_id")
	private int concert_id;
	
	public OrderTicketKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderTicketKey(Order order, int id, int cid) {
		super();
		this.order_id = order;
		this.venue_id = id;
		this.concert_id = cid;
	}

	public Order getOrder() {
		return order_id;
	}

	public void setOrder(Order order) {
		this.order_id = order;
	}

	public int getId() {
		return venue_id;
	}

	public void setId(int id) {
		this.venue_id = id;
	}

	public int getCid() {
		return concert_id;
	}

	public void setCid(int cid) {
		this.concert_id = cid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(concert_id, venue_id, order_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderTicketKey other = (OrderTicketKey) obj;
		return concert_id == other.concert_id && venue_id == other.venue_id && Objects.equals(order_id, other.order_id);
	}

	@Override
	public String toString() {
		return "OrderTicketKey order = " + order_id + ", venue id = " + venue_id + ", concert id=" + concert_id;
	}

	


}
