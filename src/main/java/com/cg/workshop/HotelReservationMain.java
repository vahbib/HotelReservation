package com.cg.workshop;
import java.util.*;

public class HotelReservationMain {
    public ArrayList<Hotel> hotelList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
    }
    //UC3
    public Hotel findCheapestHotel(String startDate, String endDate) {
        Optional<Hotel> cheapestHotel = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.rate < hotel2.rate ? hotel1 : hotel2);
        if (cheapestHotel.isPresent())
            return cheapestHotel.get();
        return null;
    }

    //UC4
    public Hotel findCheapestHotelByWeekdayRates(String startDate, String endDate) {
        Optional<Hotel> cheapestHotel = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.weekdayRate < hotel2.weekdayRate ? hotel1 : hotel2);
        if (cheapestHotel.isPresent())
            return cheapestHotel.get();
        return null;
    }
    //UC5
    public Hotel findCheapestHotelByWeekendRates(String startDate, String endDate) {
        Optional<Hotel> cheapestHotel = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.weekendRate < hotel2.weekendRate ? hotel1 : hotel2);
        if (cheapestHotel.isPresent())
            return cheapestHotel.get();
        return null;
    }
    //UC6
    public Hotel findCheapestBestRatedHotelByWeekdayRates(String startDate, String endDate) {
        double bestRating = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.rating > hotel2.rating ? hotel1 : hotel2).get().rating;
        Optional<Hotel> cheapestBestRatedHotel = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .filter(h -> h.rating == bestRating)
                .reduce((hotel1, hotel2) -> hotel1.weekdayRate < hotel2.weekdayRate ? hotel1 : hotel2);
        if (cheapestBestRatedHotel.isPresent())
            return cheapestBestRatedHotel.get();
        return null;
    }

}