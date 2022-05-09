package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "concert")
public class Concert {
	
	@Id
	@Column(name = "concert_id")
	private int id;
	@Column(name = "concert_artist")
	private String artist;
	@Column(name = "concert_seats")
	private String seats;
	@Column(name = "concert_price")
	private int price;
	@Column(name = "concert_stock")
	private int stock;
	
	public Concert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concert(int id, String artist, String seats, int price, int stock) {
		super();
		this.id = id;
		this.artist = artist;
		this.seats = seats;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, id, price, seats, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(artist, other.artist) && id == other.id && price == other.price
				&& Objects.equals(seats, other.seats) && stock == other.stock;
	}

	@Override
	public String toString() {
		return "Concert id = " + id + ", artist = " + artist + ", seats = " + seats + ", price = $" + price + ", stock = " + stock;
	}
}
