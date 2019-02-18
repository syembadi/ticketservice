Build the project:
- mvn package

Run tests:
- mvn clean test

Assumptions for the project:
- Venue capacity is set to 150 (15 rows, 10 seats each row)
- Solution doesn't guarantee the reserved seats to be in the same row
- Solution assumes the seating starts from the top row (far from screen) following downwards (towards the screen)
- Seat Hold time is set to 5 minutes in the future from the time hold action is triggered
- Seats in hold status will be shown as not available until the hold time expires 
- Confirmation code will be in the format "email+seatHoldId"