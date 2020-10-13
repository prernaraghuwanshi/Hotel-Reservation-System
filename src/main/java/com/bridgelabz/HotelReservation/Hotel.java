package com.bridgelabz.HotelReservation;

public class Hotel {
	private String hotelName;
	private int weekdayRate;
	private int weekendRate;
	private int rating;
	private int weekdayRateReward;
	private int weekendRateReward;
	private boolean isRewardee;

	// Getter for hotel name
	public String getHotelName() {
		return hotelName;
	}

	// Setter for hotel name
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	// Getter for weekday rate for reward customer
	public int getWeekdayRateReward() {
		return weekdayRateReward;
	}

	// Setter for weekday rate for reward customer
	public void setWeekdayRateReward(int weekdayRateReward) {
		this.weekdayRateReward = weekdayRateReward;
	}

	// Getter for weekend rate for reward customer
	public int getWeekendRateReward() {
		return weekendRateReward;
	}

	// Setter for weekend rate for reward customer
	public void setWeekendRateReward(int weekendRateReward) {
		this.weekendRateReward = weekendRateReward;
	}

	// Getter for if a customer is a rewardee or not
	public boolean getIsRewardee() {
		return isRewardee;
	}

	// Setter for if a customer is a rewardee or not
	public void setRewardee(boolean isRewardee) {
		this.isRewardee = isRewardee;
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
	public Hotel(String hotelName, int weekdayRate, int weekendRate, int rating, int weekdayRateReward,
			int weekendRateReward) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
		this.weekdayRateReward = weekdayRateReward;
		this.weekendRateReward = weekendRateReward;
	}
}
