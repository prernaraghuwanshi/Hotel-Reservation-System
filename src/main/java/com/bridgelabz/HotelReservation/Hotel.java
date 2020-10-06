package com.bridgelabz.HotelReservation;

/**
 * Hello world!
 *
 */
public class Hotel 
{
    private String hotelName;
    private int weekdayRate;
    private int weekendRate;
    private int rating;
    private int weekdayRateReward;
    private int weekendRateReward;
    private boolean isRewardee;
    
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getWeekdayRateReward() {
		return weekdayRateReward;
	}
	public void setWeekdayRateReward(int weekdayRateReward) {
		this.weekdayRateReward = weekdayRateReward;
	}
	public int getWeekendRateReward() {
		return weekendRateReward;
	}
	public void setWeekendRateReward(int weekendRateReward) {
		this.weekendRateReward = weekendRateReward;
	}
	public boolean isRewardee() {
		return isRewardee;
	}
	public void setRewardee(boolean isRewardee) {
		this.isRewardee = isRewardee;
	}
	public int getWeekdayRate() {
		return weekdayRate;
	}
	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}
	public int getWeekendRate() {
		return weekendRate;
	}
	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
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
