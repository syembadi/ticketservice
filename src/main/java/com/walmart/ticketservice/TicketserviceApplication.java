package com.walmart.ticketservice;

import java.util.Scanner;

/*@SpringBootApplication*/
public class TicketserviceApplication {

	public static void main(String[] args) {
		TicketServiceImpl ticket = new TicketServiceImpl(new TheatreVenue(15, 10));
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter 1 to check Seat Availability, 2 to Hold / Reserve Seats, or 0 to Exit: ");
		String userChoice = "0";
		userChoice = s.next();
		
		
		while (!userChoice.equalsIgnoreCase("0")) {
			SeatHold seatHold = null;
			String customerEmail = null;
			String confirmationCode = null;
			
			if(userChoice.equalsIgnoreCase("1"))
				System.out.println("Available seats are "+ticket.numSeatsAvailable());
			else if(userChoice.equalsIgnoreCase("2")) {
				
				if(ticket.numSeatsAvailable() == 0) {
					System.out.println("Sorry seats not available");
				} else {
					System.out.println("Enter number of seats to hold: ");
					int numSeats = Integer.parseInt(s.next());
					
					while(numSeats > ticket.numSeatsAvailable() || numSeats <= 0) {
						System.out.println("Enter valid number of seats...!!!");
						numSeats = Integer.parseInt(s.next());
					}
					
					System.out.println("Enter your Email ID: ");
					customerEmail = s.next();
					
					seatHold = ticket.findAndHoldSeats(numSeats, customerEmail);
					
					System.out.println("Do you want to continue reservation...? Enter 1 to continue, any other key to exit: ");
					if(s.next().equalsIgnoreCase("1")) {
						confirmationCode = ticket.reserveSeats(seatHold.getHoldId(), customerEmail);
						System.out.println("Your reservation confirmation code is "+confirmationCode);
					}
					else {
						System.out.println("Sorry to see you go...!!!");
						System.exit(0);
					}
				}
				
				
			}
            System.out.print("Please enter 1 to check Seat Availability, 2 to Hold / Reserve Seats, or 0 to Exit: ");
            userChoice = s.next();
		}
		System.out.println("Sorry to see you go...!!!");	
	}
}