package com.walmart.ticketservice;

import java.util.ArrayList;
import java.util.List;

public class TheatreVenue {

	private int numRows;
	private int numSeats;
	private Row[] totalRows;

	public TheatreVenue(int numRows, int numSeats) {
		this.numRows = numRows;
		this.numSeats = numSeats;

		totalRows = new Row[numRows];
		
		for(int i = 0; i < numRows; ++i) {
			totalRows[i] = new Row(numSeats);
		}
	}

	public List<Seat> getListOfAvailableSeats() {
		List<Seat> ls = new ArrayList<Seat>();
		for(Row row : totalRows){
			row.numOfSeatsPerStatus(row.getRow()).get("Available").forEach(entry -> ls.add(entry));
		}
		return ls;
	}
	
	public int getNumRows() {
		return numRows;
	}

	public int getNumSeats() {
		return numSeats;
	}
	
	public Row[] getTotalRows() {
		return totalRows;
	}
}
