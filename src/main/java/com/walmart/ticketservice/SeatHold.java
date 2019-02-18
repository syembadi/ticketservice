package com.walmart.ticketservice;

import java.time.LocalDateTime;
import java.util.List;

public class SeatHold {

	private int numSeats;
	private String customerEmail;
	private int holdId;
	private List<Seat> listOfHeldSeats;
	LocalDateTime expiryTime;
	
	public SeatHold(List<Seat> listOfHeldSeats, int numSeats, String customerEmail, int holdId, LocalDateTime expiryTime) {
		super();
		this.listOfHeldSeats = listOfHeldSeats;
		this.numSeats = numSeats;
		this.customerEmail = customerEmail;
		this.holdId = holdId;
		this.expiryTime = expiryTime;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getHoldId() {
		return holdId;
	}
	
	public void setHoldId(int holdId) {
		this.holdId = holdId;
	}

	public List<Seat> getListOfHeldSeats() {
		return listOfHeldSeats;
	}

	public void setListOfHeldSeats(List<Seat> listOfHeldSeats) {
		this.listOfHeldSeats = listOfHeldSeats;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}
	
}
