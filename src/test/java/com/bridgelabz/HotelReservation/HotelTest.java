package com.bridgelabz.HotelReservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;




public class HotelTest 
{
	HotelReservation h = null;
    @Before
    public void initialize()
    {
    	h = new HotelReservation();
    	
    }
    @Test
    public void givenDateRange_WhenBothWeekday_shouldReturnLakewood()
    {
    	ArrayList<String> dateRange = new ArrayList<String>();
    	dateRange.add("10/09/2020");
		dateRange.add("11/09/2020");
		try {
			assertEquals("Lakewood", h.findCheapestHotel(dateRange));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }
}
