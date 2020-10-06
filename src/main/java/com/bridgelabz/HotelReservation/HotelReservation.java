package com.bridgelabz.HotelReservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservation {
	Hotel lakewood = new Hotel("Lakewood", 110, 90, 3, 80, 80);
	Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4, 110, 50);
	Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
	

	public int costOfHotel(Hotel hotelName, ArrayList<String> dateRange, boolean isRewardee) throws ParseException
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Function<String,String> dateToDay = date -> {LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate.getDayOfWeek().name();
		};
		
		List<String> daysList = dateRange.stream().map(dateToDay).collect(Collectors.toList());
		
		AtomicInteger cost = new AtomicInteger(0);
		if(!isRewardee)
		{
			daysList.forEach(day -> {if(day.equals("SATURDAY") || day.equals("SUNDAY"))
			{
				cost.getAndAdd(hotelName.getWeekendRate());
			}
			else
			{
				cost.getAndAdd(hotelName.getWeekdayRate());
			}
				
			});
		}
		else
		{
			daysList.forEach(day -> {if(day.equals("SATURDAY") || day.equals("SUNDAY"))
			{
				cost.getAndAdd(hotelName.getWeekendRateReward());
			}
			else
			{
				cost.getAndAdd(hotelName.getWeekdayRateReward());
			}
				
			});
			
		}
		return cost.intValue();	
		
	}
	public String findCheapestBestRatedHotel(ArrayList<String> dateRange, boolean isRewardee) throws ParseException
	{
		HashMap<Hotel,Integer> hotelCostMap = new HashMap<Hotel, Integer>();
		int costOfLakewood = costOfHotel(lakewood, dateRange, isRewardee);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange, isRewardee);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange, isRewardee);
		hotelCostMap.put(lakewood, costOfLakewood);
		hotelCostMap.put(bridgewood, costOfBridgewood);
		hotelCostMap.put(ridgewood, costOfRidgewood);
		
		
		int index = -1;
//		int minCost = hotelCostMap.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getValue).orElse(null);
		
		int minCost = hotelCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		hotelCostMap.forEach((k,v)-> {
			if(minCost == v)
				hotelList.add(k);
		});

		if(hotelList.size() == 1)
		{
			index = 0;
			System.out.println("Cheapest Hotel: "+hotelList.get(index).getHotelName());
			System.out.println("Cost = $"+ minCost);
			System.out.println("Rating: "+hotelList.get(index).getRating());
			return hotelList.get(index).getHotelName();
		}
		else
		{
			int maxRating = hotelList.stream().max(Comparator.comparingInt(Hotel::getRating)).get().getRating();
			Predicate<Hotel> maxRatedHotel = hotel -> hotel.getRating() == maxRating;
			Hotel hotelOutput = hotelList.stream().filter(maxRatedHotel).findFirst().orElse(null);
			System.out.println("Cheapest Hotel: "+hotelOutput.getHotelName());
			System.out.println("Cost = $"+ minCost);
			System.out.println("Rating: "+maxRating);
			return hotelOutput.getHotelName();
		}

	}
	
	
	public int maxOfThree(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}
	
	public String findBestRatedHotel(ArrayList<String> dateRange, boolean isRewardee) throws ParseException
	{
		int bestRating = maxOfThree(lakewood.getRating(), bridgewood.getRating(), ridgewood.getRating());
		String outputHotel;
		int cost; 
		if(bestRating == lakewood.getRating())
		{
			outputHotel = "Lakewood";
			cost = costOfHotel(lakewood, dateRange, isRewardee);
		}
		else if (bestRating == bridgewood.getRating())
		{
			outputHotel = "Bridgewood";
			cost = costOfHotel(bridgewood, dateRange, isRewardee);
		}
		else
		{
			outputHotel = "Ridgewood";
			cost = costOfHotel(ridgewood, dateRange, isRewardee);
		}
		System.out.println("Best rated Hotel: "+outputHotel);
		System.out.println("Cost = $"+ cost);
		System.out.println("Rating: "+ bestRating);
		return outputHotel;
	}
	
	public static void main(String args[]) throws ParseException {
		System.out.println("Welcome to Hotel Reservation Program!");

		
	}
	

}
