package com.revature.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Concert {
	
	private String artist;
	private String seats;
	private int price;
	private int stock;
	
	public Concert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concert(String artist, String seats, int price, int stock) {
		super();
		this.artist = artist;
		this.seats = seats;
		this.price = price;
		this.stock = stock;
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
		return Objects.hash(artist, price, seats, stock);
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
		return Objects.equals(artist, other.artist) && price == other.price && Objects.equals(seats, other.seats)
				&& stock == other.stock;
	}

	@Override
	public String toString() {
		return "Concert artist = " + artist + ", seats = " + seats + ", price = $" + price + ", stock = " + stock;
	}
	
}
