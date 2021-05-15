package collections.one;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
	private final String theatreName;
	static final Comparator<Seat> PRICE_ORDER = (s1, s2) -> {
		if(s1.getPrice() < s2.getPrice()) {
			return -1;
		} else if(s1.getPrice() > s2.getPrice()) {
			return 1;
		} else {
			return 0;
		}
	};

	// https://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/
	public List<Seat> seats = new ArrayList<>();

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		this.init(numRows, seatsPerRow);
	}

	private void init(int numRows, int seatsPerRow) {
		int lastRow = 'A' + (numRows - 1);

		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				double price = 12.00;
				
				if((row < 'D') && (seatNum >= 4 && seatNum <=9)) {
					price = 14.00;
				} else if((row > 'F') || seatNum < 4 || seatNum > 9) {
					price = 7.00;
				}
				
				Seat seat = new Seat(row + String.format("%02d", seatNum), price);
				seats.add(seat);
			}
		}
	}
	

	public String getTheatreName() {
		return theatreName;
	}

	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = new Seat(seatNumber, 0.00);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		
		if(foundSeat >= 0) {
			return seats.get(foundSeat).reserve();
		} else {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}

//		for (Seat seat : seats) {
//			System.out.print(".");
//			if (seat.getSeatNumber().equals(seatNumber)) {
//				requestedSeat = seat;
//				break;
//			}
//		}

//		if (requestedSeat == null) {
//			System.out.println("There is no seat " + seatNumber);
//			return false;
//		}

//		return requestedSeat.reserve();
	}

	// for testing
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	public Collection<Seat> getSeatsCollection() {
		return this.seats;
	}

	public class Seat implements Comparable<Seat> {
		private final String seatNumber;
		private boolean reserved = false;
		private double price;

		public Seat(String seatNumber, double price) {
			this.seatNumber = seatNumber;
			this.price = price;
		}

		public boolean reserve() {
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Seat " + seatNumber + " reserved");
				return true;
			} else {
				System.out.println("Seat " + seatNumber + " already reserved");
				return false;
			}
		}

		public boolean cancel() {
			if (this.reserved) {
				this.reserved = false;
				System.out.println("Reservation of seat " + seatNumber + " cancelled");
				return true;
			} else {
				return false;
			}
		}

		public String getSeatNumber() {
			return seatNumber;
		}
		
		

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public int compareTo(Seat seat) {
			int result = this.getSeatNumber().compareToIgnoreCase(seat.getSeatNumber());
			// System.out.println("compareTo ...");
			return result;
		}
	}
}
