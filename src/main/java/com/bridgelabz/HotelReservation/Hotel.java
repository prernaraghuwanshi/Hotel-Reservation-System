package com.bridgelabz.HotelReservation;

public class Hotel {
	private String hotelName;
	private int weekdayRate;
	private int weekendRate;
	private int rating;

	// Getter for Hotel name
	public String getHotelName() {
		return hotelName;
	}

	// Setter for Hotel name
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	// Getter for Weekday rate
	public int getWeekdayRate() {
		return weekdayRate;
	}

	// Setter for Weekday rate
	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	// Getter for Weekend rate
	public int getWeekendRate() {
		return weekendRate;
	}

	// Setter for Weekend rate
	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	// Getter for Rating
	public int getRating() {
		return rating;
	}

	// Setter for Rating
	public void setRating(int rating) {
		this.rating = rating;
	}

	// Constructor
	public Hotel(String hotelName, int weekdayRate, int weekendRate, int rating) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
	}
}