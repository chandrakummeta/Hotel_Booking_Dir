//----------------------------------------------------------------
//AUTHOR NAME :- Pooja Chawla
//Objective:  main controller to call booking and cancellations methods
//CREATED DATE :- 11/07/2017
//VERSION :- 1.0
//===============================================================

package executionEngine;

import cancellation_hotel.cancellationdetails;
import booking_hotel.bookingdetails;

public class runTest {

	public static void main(String[] args) 
	{	
	
		
		System.out.println("\n\nInitiating Booking process......\n");
		bookingdetails.savebooking();
		
		System.out.println("\nInitiating Cancellation process......\n");
		cancellationdetails.cancelbooking();
		

	}

}
