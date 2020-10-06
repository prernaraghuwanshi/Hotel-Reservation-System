package com.bridgelabz.HotelReservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HotelReservation {
	Hotel lakewood = new Hotel("Lakewood", 110, 90, 3, 80, 80);
	Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4, 110, 50);
	Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
	
	public String dateToDay(String date) throws ParseException 
	{
		SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		Date dt = format1.parse(date);
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		String day=format2.format(dt);
		return day;
	}
	public int costOfHotel(Hotel hotelName, ArrayList<String> dateRange, boolean isRewardee) throws ParseException
	{
		Iterator<String> it = dateRange.iterator();
		int cost = 0;
		while(it.hasNext())
		{
			String day = dateToDay(it.next());
			if(!isRewardee)
			{
				if(day.equals("Saturday") || day.equals("Sunday"))
				{
					cost += hotelName.getWeekendRate();
				}
				else
				{
					cost += hotelName.getWeekdayRate();
				}
			}
			else
			{
				if(day.equals("Saturday") || day.equals("Sunday"))
				{
					cost += hotelName.getWeekendRateReward();
				}
				else
				{
					cost += hotelName.getWeekdayRateReward();
				}
			}
		}
		return cost;
	}
	public int minOfThree(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
	}
	public int maxOfThree(int a, int b, int c)
	{
		return Math.max(Math.max(a, b), c);
	}
	public String findCheapestHotel(ArrayList<String> dateRange, boolean isRewardee) throws ParseException
	{
		int costOfLakewood = costOfHotel(lakewood, dateRange, isRewardee);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange,isRewardee);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange, isRewardee);
		
		int minCost = minOfThree(costOfLakewood, costOfBridgewood, costOfRidgewood);
		
		if(minCost == costOfLakewood)
		{
			System.out.println("Cheapest Hotel: Lakewood");
			System.out.println("Cost = $"+ costOfLakewood);
			return "Lakewood";
		}
		else if (minCost == costOfBridgewood)
		{
			System.out.println("Cheapest Hotel: Bridgewood");
			System.out.println("Cost = $"+ costOfBridgewood);
			return "Bridgewood";
		}
		else
		{
			System.out.println("Cheapest Hotel: Ridgewood");
			System.out.println("Cost = $"+ costOfRidgewood);
			return "Ridgewood";
		}
	}
	public String findCheapestBestRatedHotel(ArrayList<String> dateRange, boolean isRewardee) throws ParseException
	{
		int costOfLakewood = costOfHotel(lakewood, dateRange, isRewardee);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange, isRewardee);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange, isRewardee);
		int index = -1;
		int minCost = minOfThree(costOfLakewood, costOfBridgewood, costOfRidgewood);
		List<Hotel> hotelList = new ArrayList<Hotel>();
		if(minCost == costOfLakewood)
		{
			hotelList.add(lakewood);
		}
		if (minCost == costOfBridgewood)
		{
			hotelList.add(bridgewood);
		}
		if (minCost == costOfRidgewood)
		{
			hotelList.add(ridgewood);
		}
		if(hotelList.size() == 1)
		{
			index = 0;
		}
		else
		{
			int maxRating = 0;
			for(int i = 0; i< hotelList.size(); i++)
			{
				if(hotelList.get(i).getRating() > maxRating)
				{
					maxRating = hotelList.get(i).getRating();
					index = i;
				}
			}
		}
		System.out.println("Cheapest Hotel: "+hotelList.get(index).getHotelName());
		System.out.println("Cost = $"+ minCost);
		System.out.println("Rating: "+hotelList.get(index).getRating());
		return hotelList.get(index).getHotelName();
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
//		HotelReservation h = new HotelReservation();
//
//		ArrayList<String> dateRange = new ArrayList<String>();
//		dateRange.add("11/09/2020");
//		dateRange.add("12/09/2020");
//
//		boolean isRewardee = true;
//		h.findCheapestBestRatedHotel(dateRange, isRewardee);
//		
		
	}
	

}
