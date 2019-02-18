package com.walmart.ticketservice;

public class Seat {

	private boolean reserved = false;
	private boolean hold = false;
	private boolean available = true;
	
	
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
		if(reserved == true)
			this.available = false;
		else if (reserved == false)
			this.available = true;
	}
	public boolean isHold() {
		return hold;
	}
	public void setHold(boolean hold) {
		this.hold = hold;
		if(hold == true)
			this.available = false;
		else if (hold == false)
			this.available = true;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
