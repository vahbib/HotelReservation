package com.cg.workshop;

public class Hotel {
    public String hotelName;
    public double rate;
    public String startDate;
    public String endDate;

    public Hotel(String hotelName, int rate) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.startDate = " ";
        this.endDate = " ";
    }

    public Hotel(String hotelName, double rate, String startDate, String endDate) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
