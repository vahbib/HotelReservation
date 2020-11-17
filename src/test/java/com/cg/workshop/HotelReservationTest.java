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
        String hotelName = "RockFort";
        int rate = 10000;
        Hotel hotel = new Hotel(hotelName, rate);
        Assert.assertTrue(hotel != null);
    }

    @Test
    public void givenHotelList_ShouldReturnCheapestHotel() {
        hotelReservationMain.hotelList.add(new Hotel("RockFort", 10000));
        hotelReservationMain.hotelList.add(new Hotel("Hotel Beach House", 6000));
        hotelReservationMain.hotelList.add(new Hotel("Taj Mahal", 9000));
        String cheapestHotel = hotelReservationMain.findCheapestHotel();
        Assert.assertEquals("Hotel Beach House", cheapestHotel);
    }
}
