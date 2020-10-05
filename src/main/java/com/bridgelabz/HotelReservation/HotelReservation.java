package com.bridgelabz.HotelReservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class HotelReservation {
	Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
	Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
	Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
	
	public String dateToDay(String date) throws ParseException 
	{
		SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		Date dt = format1.parse(date);
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		String day=format2.format(dt);
		return day;
	}
	public int costOfHotel(Hotel hotelName, ArrayList<String> dateRange) throws ParseException
	{
		Iterator<String> it = dateRange.iterator();
		int cost = 0;
		while(it.hasNext())
		{
			String day = dateToDay(it.next());
			if(day == "Saturday" || day == "Sunday")
			{
				cost += hotelName.getWeekendRate();
			}
			else
			{
				cost += hotelName.getWeekdayRate();
			}
		}
		return cost;
	}
	public int minOfThree(int a, int b, int c)
	{
		return Math.min(Math.min(a, b), c);
	}
	public String findCheapestHotel(ArrayList<String> dateRange) throws ParseException
	{
		int costOfLakewood = costOfHotel(lakewood, dateRange);
		int costOfBridgewood = costOfHotel(bridgewood, dateRange);
		int costOfRidgewood = costOfHotel(ridgewood, dateRange);
		
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
	public static void main(String args[]) throws ParseException {
		System.out.println("Welcome to Hotel Reservation Program!");
		//HotelReservation h = new HotelReservation();
		
		//ArrayList<String> dateRange = new ArrayList<String>();
//		dateRange.add("10/09/2020");
//		dateRange.add("11/09/2020");
//		
//		h.findCheapestHotel(dateRange);
		
	}
	

}
