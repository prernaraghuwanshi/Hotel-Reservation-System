package com.bridgelabz.HotelReservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservation {
	Hotel lakewood = new Hotel("Lakewood", 110, 90, 3, 80, 80);
	Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4, 110, 50);
	Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5, 100, 40);

	// Function to find cost of a hotel
	public int costOfHotel(Hotel hotelName, ArrayList<String> dateRange, boolean isRewardee) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Function<String, String> dateToDay = date -> {
			LocalDate localDate = LocalDate.parse(date, formatter);
			return localDate.getDayOfWeek().name();
		};
		List<String> daysList = dateRange.stream().map(dateToDay).collect(Collectors.toList());
		AtomicInteger cost = new AtomicInteger(0);
		if (!isRewardee) {
			daysList.forEach(day -> {
				if (day.equals("SATURDAY") || day.equals("SUNDAY")) {
					cost.getAndAdd(hotelName.getWeekendRate());
				} else {
					cost.getAndAdd(hotelName.getWeekdayRate());
				}

			});
		} else {
			daysList.forEach(day -> {
				if (day.equals("SATURDAY") || day.equals("SUNDAY")) {
					cost.getAndAdd(hotelName.getWeekendRateReward());
				} else {
					cost.getAndAdd(hotelName.getWeekdayRateReward());
				}
			});
		}
		return cost.intValue();
	}

	// Function to find cheapest and best rated hotel
	public String findCheapestBestRatedHotel(ArrayList<String> dateRange, boolean isRewardee) {
		HashMap<Hotel, Integer> hotelCostMap = new HashMap<Hotel, Integer>();
		int costOfLakewood = costOfHotel(lakewood, dateRange, isRewardee);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange, isRewardee);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange, isRewardee);
		hotelCostMap.put(lakewood, costOfLakewood);
		hotelCostMap.put(bridgewood, costOfBridgewood);
		hotelCostMap.put(ridgewood, costOfRidgewood);
		int index = -1;
		int minCost = hotelCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		hotelCostMap.forEach((k, v) -> {
			if (minCost == v)
				hotelList.add(k);
		});
		if (hotelList.size() == 1) {
			index = 0;
			System.out.println("Cheapest Hotel: " + hotelList.get(index).getHotelName());
			System.out.println("Cost = $" + minCost);
			System.out.println("Rating: " + hotelList.get(index).getRating());
			return hotelList.get(index).getHotelName();
		} else {
			int maxRating = hotelList.stream().max(Comparator.comparingInt(Hotel::getRating)).get().getRating();
			Predicate<Hotel> maxRatedHotel = hotel -> hotel.getRating() == maxRating;
			Hotel hotelOutput = hotelList.stream().filter(maxRatedHotel).findFirst().orElse(null);
			System.out.println("Cheapest Hotel: " + hotelOutput.getHotelName());
			System.out.println("Cost = $" + minCost);
			System.out.println("Rating: " + maxRating);
			return hotelOutput.getHotelName();
		}
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Hotel Reservation Program!");
	}
}
