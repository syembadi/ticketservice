package com.walmart.ticketservice;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class TicketserviceApplicationTests {

	TicketServiceImpl ticketServiceImpl = new TicketServiceImpl(new TheatreVenue(15, 10));
	
	@Test
	public void availableSeatsTest() {
		Assert.assertEquals(150, ticketServiceImpl.numSeatsAvailable());
		
	}
	
	@Test
	public void holdSeatsTest() {
		int numSeats = 5;
		String email = "test@test.com";
		SeatHold seatHold = ticketServiceImpl.findAndHoldSeats(numSeats, email);
		
		Assert.assertEquals(numSeats, seatHold.getNumSeats());
		Assert.assertEquals(email, seatHold.getCustomerEmail());
	}

	@Test
	public void holdAndReserveSeatsTest() {
		int numSeats = 5;
		String email = "test@test.com";
		String reserveResponse = null;
		
		SeatHold seatHold = ticketServiceImpl.findAndHoldSeats(numSeats, email);
		
		//to test ticket hold time out scenario
		seatHold.setExpiryTime(LocalDateTime.now().minusMinutes(1));
		reserveResponse = ticketServiceImpl.reserveSeats(seatHold.getHoldId(), email);
		Assert.assertEquals(reserveResponse, "Time up, Reservation unsuccessful...!!!");
		
		//to test holding and reserving within hold time
		seatHold.setExpiryTime(LocalDateTime.now().plusMinutes(5));
		reserveResponse = ticketServiceImpl.reserveSeats(seatHold.getHoldId(), email);
		Assert.assertEquals(reserveResponse, email+Integer.toString(seatHold.getHoldId()));
	}
}

