package com.cg.workshop;

import org.junit.*;

public class HotelReservationTest {
    HotelReservationMain hotelReservationMain;

    @Before
    public void setup() {
        hotelReservationMain = new HotelReservationMain();
    }

    @Test
    public void givenDetails_WhenHotelObjectCreated_ShouldReturnTrue() {
        String hotelName = "ITC";
        int rate = 10000;
        Hotel hotel = new Hotel(hotelName, rate);
        Assert.assertTrue(hotel != null);
    }

    @Test
    public void givenHotelList_ShouldReturnCheapestHotelInGivenDateRange() {
        hotelReservationMain.hotelList.add(new Hotel("ITC", 10000, "2020-01-25", "2020-01-26"));
        hotelReservationMain.hotelList.add(new Hotel("Taj", 6000, "2020-02-12", "2020-02-14"));
        hotelReservationMain.hotelList.add(new Hotel("Mahindra", 9000, "2020-11-01", "2020-11-04"));
        Hotel cheapestHotel = hotelReservationMain.findCheapestHotel("2020-01-01", "2020-12-31");
        Assert.assertEquals("Taj", cheapestHotel.hotelName);
    }
}

