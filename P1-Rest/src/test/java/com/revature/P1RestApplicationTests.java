package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.revature.model.Venue;
import com.revature.repository.VenueRepository;
import com.revature.service.VenueService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class P1RestApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@InjectMocks
	private VenueService venueService;
	
	@Mock
	private VenueRepository venueRepository;
	
	private List<Venue> mockVenue;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.venueService = new VenueService();
		this.mockVenue = new  ArrayList<Venue>();
		this.mockVenue.add(new Venue(1, "May", 16 , "Foo-Fighters", "http://localhost:8081/concert?artist=Foo-Fighters"));
		this.mockVenue.add(new Venue(2, "June", 12, "Paul-McCartney", "http://localhost:8081/concert?artist=Paul-McCartney"));
		this.mockVenue.add(new Venue(3, "August", 20, "Chris-Stapleton", "http://localhost:8081/concert?artist=Chris-Stapleton"));
	}

	@Test
	public void testMockFindAllVenue() {
		Mockito.when(this.venueRepository.findAll()).thenReturn(mockVenue);
		List<Venue> venue = this.venueService.findAll();
		Assertions.assertEquals(3, venue.size());
	}
	
	@Test
	public void testRestTemplate() throws Exception{
		assertThat(this.restTemplate.getRestTemplate());
	}
	
	@Test
	public void testFindAllVenue() throws Exception {
		assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/venue/all",
				List.class));
	}
	
	@Test
	public void testFindAllConcert() throws Exception {
		assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/venue/concert/all",
				List.class));
	}
	
	@Test
	public void testFindByMonthVenue() throws Exception {
		
		String[] month = {"May", "June", "July", "August", "September"};
		for(int i = 0; i < month.length; i++) {
			assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/venue/" + month[i],
				List.class));
			}
	}
	
	@Test
	public void testFindByArtistConcert() throws Exception {
		
		String[] artist = {"Foo-Fighters", "The-Luminners", "Robert-Plant", "Paul-McCartney", "The-Black-Keys", "Chris-Stapleton", "Blondie", "The-Killers"};
		for(int i = 0; i < artist.length; i++) {
			assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/venue/concert/" + artist[i],
				List.class));
			}
	}
}
