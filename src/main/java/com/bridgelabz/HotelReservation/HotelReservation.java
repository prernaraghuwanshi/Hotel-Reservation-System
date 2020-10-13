package com.bridgelabz.HotelReservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class HotelReservation {
	Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
	Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
	Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);

	// Takes date and gives day of the week as output
	public String dateToDay(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate.getDayOfWeek().name();
	}

	// Function to find cost of a hotel
	public int costOfHotel(Hotel hotelName, ArrayList<String> dateRange) {
		Iterator<String> it = dateRange.iterator();
		int cost = 0;
		while (it.hasNext()) {
			String day = dateToDay(it.next());
			if (day == "SATURDAY" || day == "SUNDAY") {
				cost += hotelName.getWeekendRate();
			} else {
				cost += hotelName.getWeekdayRate();
			}
		}
		return cost;
	}

	// Function to find minimum of three value
	public int minOfThree(int value1, int value2, int value3) {
		return Math.min(Math.min(value1, value2), value3);
	}

	// Function to find Cheapest hotel in the given date range
	public String findCheapestHotel(ArrayList<String> dateRange) {
		int costOfLakewood = costOfHotel(lakewood, dateRange);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange);
		int minCost = minOfThree(costOfLakewood, costOfBridgewood, costOfRidgewood);
		if (minCost == costOfLakewood) {
			System.out.println("Cheapest Hotel: Lakewood");
			System.out.println("Cost = $" + costOfLakewood);
			return "Lakewood";
		} else if (minCost == costOfBridgewood) {
			System.out.println("Cheapest Hotel: Bridgewood");
			System.out.println("Cost = $" + costOfBridgewood);
			return "Bridgewood";
		} else {
			System.out.println("Cheapest Hotel: Ridgewood");
			System.out.println("Cost = $" + costOfRidgewood);
			return "Ridgewood";
		}
	}

	// Function to find maximum of three values
	public int maxOfThree(int value1, int value2, int value3) {
		return Math.max(Math.max(value1, value2), value3);
	}

	// Function to find cheapest and best rated hotel
	public String findCheapestBestRatedHotel(ArrayList<String> dateRange) {
		int costOfLakewood = costOfHotel(lakewood, dateRange);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange);
		int minCost = minOfThree(costOfLakewood, costOfBridgewood, costOfRidgewood);
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		if (minCost == costOfLakewood) {
			hotelList.add(lakewood);
		}
		if (minCost == costOfBridgewood) {
			hotelList.add(bridgewood);
		}
		if (minCost == costOfRidgewood) {
			hotelList.add(ridgewood);
		}
		if (hotelList.size() == 1) {
			System.out.println("Cheapest Hotel: " + hotelList.get(0).getHotelName());
			System.out.println("Cost = $" + minCost);
			System.out.println("Rating: " + hotelList.get(0).getRating());
			return hotelList.get(0).getHotelName();
		} else {
			int maxRating = 0;
			int index = -1;
			for (int i = 0; i < hotelList.size(); i++) {
				if (hotelList.get(i).getRating() > maxRating) {
					maxRating = hotelList.get(i).getRating();
					index = i;
				}
			}
			System.out.println("Cheapest Hotel: " + hotelList.get(index).getHotelName());
			System.out.println("Cost = $" + minCost);
			System.out.println("Rating: " + hotelList.get(index).getRating());
			return hotelList.get(index).getHotelName();
		}
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Hotel Reservation Program!");
	}
}
