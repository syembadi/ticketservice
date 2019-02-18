package com.walmart.ticketservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketServiceImpl implements TicketService{

	int uniqueId = 0;
	private HashMap<Integer, SeatHold> holdMap = new HashMap<Integer, SeatHold>();
	private List<Seat> listOfAvailableSeats;
	private TheatreVenue theatreVenue;
	
	public TicketServiceImpl(TheatreVenue theatreVenue) {
		this.theatreVenue = theatreVenue;
		listOfAvailableSeats = theatreVenue.getListOfAvailableSeats();
	}

	@Override
	public int numSeatsAvailable() {
		listOfAvailableSeats = theatreVenue.getListOfAvailableSeats();
		return listOfAvailableSeats.size();
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		SeatHold seatHold = null;
		if(listOfAvailableSeats.size()==0) {
			System.out.println("Sorry seats not available");
			return null;
		}
			
		if(numSeats < 1 || numSeats > listOfAvailableSeats.size()) {
			System.out.println("Invalid number of seats entered.");
			return null;
		} 
		
		if (numSeats <= listOfAvailableSeats.size()) {
			synchronized(this) {
				int holdId = getUniqueId();
				List<Seat> listOfHeldSeats = new ArrayList<Seat>();
				for(int i=0; i<numSeats; i++) {
					listOfAvailableSeats.get(i).setHold(true);
					listOfHeldSeats.add(listOfAvailableSeats.get(i));
				}
				seatHold = new SeatHold(listOfHeldSeats, numSeats, customerEmail, holdId, LocalDateTime.now().plusMinutes(5));
				holdMap.put(holdId, seatHold);
			}
		}	
		return seatHold;
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		SeatHold seatHold = holdMap.get(seatHoldId);
		List<Seat> listOfHeldSeats = seatHold.getListOfHeldSeats();
		
		if(seatHold.getExpiryTime().isBefore(LocalDateTime.now())) {
			return "Time up, Reservation unsuccessful...!!!";
			/*System.out.println("Time up, Reservation unsuccessful...!!!");
			System.exit(0);*/
		} else {
			for(int i=0; i<listOfHeldSeats.size(); i++) {
				listOfHeldSeats.get(i).setReserved(true);
			}
		}
		return customerEmail+Integer.toString(seatHoldId);
	}
	
	synchronized int getUniqueId()
	{
	    return uniqueId++;
	}

}
