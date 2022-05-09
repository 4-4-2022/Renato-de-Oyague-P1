package com.revature.dto;

public class Order {

	private int order_id;
	private int user_id;
	private String status;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int user_id, String status) {
		super();
		this.order_id = id;
		this.user_id = user_id;
		this.status = status;
	}

	public int getId() {
		return order_id;
	}

	public void setId(int id) {
		this.order_id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + user_id;
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
		Order other = (Order) obj;
		if (order_id != other.order_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + order_id + ", user_id=" + user_id + ", status=" + status + "]";
	}
}
