package com.bridgelabz.HotelReservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class HotelReservation {
	Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
	Hotel bridgewood = new Hotel("Bridgewood", 160, 60, 4);
	Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);

	public String dateToDay(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate.getDayOfWeek().name();
	}

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

	public int minOfThree(int value1, int value2, int value3) {
		return Math.min(Math.min(value1, value2), value3);
	}

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

	public static void main(String args[]) throws ParseException {
		System.out.println("Welcome to Hotel Reservation Program!");
	}
}
