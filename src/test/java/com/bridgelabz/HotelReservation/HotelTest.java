package com.bridgelabz.HotelReservation;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class HotelTest {
	HotelReservation h = null;

	@Before
	public void initialize() {
		h = new HotelReservation();
	}

	@Test
	public void givenDateRange_WhenBothWeekday_shouldReturnLakewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = false;
		dateRange.add("10/09/2020");
		dateRange.add("11/09/2020");
		assertEquals("Lakewood", h.findCheapestBestRatedHotel(dateRange, isRewardee));
	}

	@Test
	public void givenDateRange_WhenBothWeekend_shouldReturnLakewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = false;
		dateRange.add("12/09/2020");
		dateRange.add("13/09/2020");
		assertEquals("Bridgewood", h.findCheapestBestRatedHotel(dateRange, isRewardee));
	}

	@Test
	public void givenDateRange_WhenOneWeekdayOneWeekend_shouldReturnBridgewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = false;
		dateRange.add("11/09/2020");
		dateRange.add("12/09/2020");
		assertEquals("Bridgewood", h.findCheapestBestRatedHotel(dateRange, isRewardee));
	}

	@Test
	public void givenDateRange_WhenFindingBestRatedHotel_shouldReturnRidgewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = false;
		dateRange.add("11/09/2020");
		dateRange.add("12/09/2020");
		assertEquals("Ridgewood", h.findBestRatedHotel(dateRange, isRewardee));
	}

	@Test
	public void givenDateRangeAndRewardee_WhenBothWeekday_shouldReturnLakewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = true;
		dateRange.add("10/09/2020");
		dateRange.add("11/09/2020");
		assertEquals("Lakewood", h.findCheapestBestRatedHotel(dateRange, isRewardee));
	}

	@Test
	public void givenDateRangeAndRewardee_WhenBothWeekend_shouldReturnLakewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = true;
		dateRange.add("12/09/2020");
		dateRange.add("13/09/2020");
		assertEquals("Ridgewood", h.findCheapestBestRatedHotel(dateRange, isRewardee));
	}

	@Test
	public void givenDateRangeAndRewardee_WhenOneWeekdayOneWeekend_shouldReturnBridgewood() {
		ArrayList<String> dateRange = new ArrayList<String>();
		boolean isRewardee = true;
		dateRange.add("11/09/2020");
		dateRange.add("12/09/2020");
		assertEquals("Ridgewood", h.findCheapestBestRatedHotel(dateRange, isRewardee));
	}
}
