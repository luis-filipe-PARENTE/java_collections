package collections.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	// https://www.baeldung.com/java-copy-list-to-another

    public static void main(String[] args) {
    	// sample1();
    	sample2();
    }
    
    private static void sample1() {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
//      theatre.getSeats();
//
//      if(theatre.reserveSeat("H11")) {
//          System.out.println("Please pay");
//      } else {
//          System.out.println("Sorry, seat is taken");
//      }
//      
//      if(theatre.reserveSeat("H11")) {
//          System.out.println("Please pay");
//      } else {
//          System.out.println("Sorry, seat is taken");
//      }
	    
	    List<Theatre.Seat> seatsCopy = new ArrayList<Theatre.Seat>(theatre.seats);
	    
	    seatsCopy.get(1).reserve();
	    
	    if(theatre.reserveSeat("A02")) {
	    	System.out.println("Please pay for A02");
	    } else {
	    	System.out.println("Seat already reseved...");
	    }
	    
	    printList(seatsCopy);
	    
	    Collections.reverse(seatsCopy);
	    System.out.println("Printing seatsCopy list (reverse) ...");
	    printList(seatsCopy);
	    
	    Collections.shuffle(seatsCopy);
	    System.out.println("Printing seatsCopy list (shuffle) ...");
	    printList(seatsCopy);
	    
	    Collections.shuffle(seatsCopy);
	    sortList(seatsCopy);
	    System.out.println("Printing seatsCopy list (shuffle and sort) ...");
	    printList(seatsCopy);
	    
	    
	    System.out.println("Printing theatre.seats list...");
	    printList(theatre.seats);
	    
	    Theatre.Seat minSeat = Collections.min(seatsCopy);
	    Theatre.Seat maxSeat = Collections.max(seatsCopy);
	    
	    System.out.println("Min seat number is " + minSeat.getSeatNumber());
	    System.out.println("Max seat number is " + maxSeat.getSeatNumber());
	    System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================");
  	 
	    
	    // Deep copy 
	    // https://coderanch.com/t/387461/java/Collections-copy
	    // List<Theatre.Seat> newlist = new ArrayList<Theatre.Seat>(theatre.seats.size()); (wrong)
	    List<Theatre.Seat> newlist  = Arrays.asList(new Theatre.Seat[theatre.seats.size()]);
	    
	    Collections.copy(newlist, theatre.seats);
	    
	    System.out.println("Printing newlist deep copy...");
	    printList(theatre.seats);
	    
	    if(theatre.reserveSeat("A03")) {
	    	System.out.println("Please pay for A03");
	    } else {
	    	System.out.println("Seat already reseved...");
	    }
	    
	    newlist.get(2).reserve();
	    
    }

    private static void sample2() {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
	    final String reserveSeat  = "D12";
	    final String reserveSeatForError = "B13";
	    
	    reserveSeatOnTheatre(theatre, reserveSeat);
	    reserveSeatOnTheatre(theatre, reserveSeatForError);
	    
	    List<Theatre.Seat> reverseSeats = new ArrayList<Theatre.Seat>(theatre.seats);
	    Collections.reverse(reverseSeats);
	    System.out.println("Printing reversed list...");
	    printList(reverseSeats);
	    
	    
	    List<Theatre.Seat> priceSeats = new ArrayList<Theatre.Seat>(theatre.seats);
	    priceSeats.add(theatre.new Seat("B00", 13.00));
	    priceSeats.add(theatre.new Seat("A00", 13.00));
	    priceSeats.add(theatre.new Seat("C00", 13.00));
	    
	    System.out.println("Printing priceSeats list ordered by price...");
	    Collections.sort(priceSeats, Theatre.PRICE_ORDER);
	    printList(priceSeats);
    }
    
    private static void reserveSeatOnTheatre(Theatre theatre, String seatToReserve) {
	    if(theatre.reserveSeat(seatToReserve)) {
	    	System.out.println("Please pay for " + seatToReserve);
	    } else {
	    	System.out.println("Seat" + seatToReserve + " already reseved...");
	    }
    }
    
    private static void printList(List<? extends Theatre.Seat> list) {
    	list.forEach(s -> System.out.print(" " + s.getSeatNumber() + " " + s.getPrice()));
    	System.out.println();
    	System.out.println("=================================================================================================================================================================================================================================================================================================================================================================================================");
    }
    
    private static void sortList(List<? extends Theatre.Seat> listToSort) {
    	for(int i=0; i< listToSort.size() -1; i++) {
    		for(int j=i+1; j < listToSort.size() -1; j++) {
    			if(listToSort.get(i).compareTo(listToSort.get(j)) > 0) {
    				Collections.swap(listToSort, i, j);
    			}
    		}
    	}
    }
}
