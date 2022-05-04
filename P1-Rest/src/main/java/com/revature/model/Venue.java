package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venue")
public class Venue {
	
	@Column(name = "venue_month")
	private String month;
	@Column(name = "venue_day")
	private int day;
	@Id
	@Column(name = "venue_artist")
	private String artist;
	@Column(name = "venue_url")
	private String url;
	
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venue(String month, int day, String artist, String url) {
		super();
		this.month = month;
		this.day = day;
		this.artist = artist;
		this.url = url;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, day, month, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		return Objects.equals(artist, other.artist) && day == other.day && Objects.equals(month, other.month)
				&& Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Venue month = " + month + ", day = " + day + ", artist = " + artist + ", URL = " + url;
	}

}
