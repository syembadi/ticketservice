package com.walmart.ticketservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Row {

	private Seat[] row;
	
	public Row(int numSeats) {
		row = new Seat[numSeats];
		for(int i = 0; i < numSeats; ++i) {
			row[i] = new Seat();
		}
	}
	
	public Seat[] getRow() {
		return row;
	}
	
	public Map<String, List<Seat>> numOfSeatsPerStatus(Seat[] row) {
		
		List<Seat> listOfReservedSeats = new ArrayList<Seat>();
		List<Seat> listOfHeldSeats = new ArrayList<Seat>();
		List<Seat> listOfAvailableSeats = new ArrayList<Seat>();
		Map<String, List<Seat>> seatStatus = new HashMap<String, List<Seat>>();
		
		for(Seat seat : row) {
			if(seat.isReserved() == true) {
				listOfReservedSeats.add(seat);
			}else if(seat.isHold()==true) {
				listOfHeldSeats.add(seat);
			}else if(seat.isAvailable()==true){
				listOfAvailableSeats.add(seat);
			}
		}
		seatStatus.put("Reserved", listOfReservedSeats);
		seatStatus.put("Held", listOfHeldSeats);
		seatStatus.put("Available", listOfAvailableSeats);
		return seatStatus;
	}

}
