package com.cg.workshop;

import java.util.*;

public class HotelReservationMain {
    public ArrayList<Hotel> hotelList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
    }

    public String findCheapestHotel()
    {
        String minRateHotel = hotelList.get(0).hotelName;
        double minRate = hotelList.get(0).rate;
        for (Hotel hotel : hotelList) {
            if (hotel.rate < minRate) {
                minRate = hotel.rate;
                minRateHotel = hotel.hotelName;
            }
        }
        return minRateHotel;
    }
}
