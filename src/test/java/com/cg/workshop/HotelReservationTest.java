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
        String hotelName = "Oberoi";
        int rate = 10000;
        Hotel hotel = new Hotel(hotelName, rate);
        Assert.assertTrue(hotel != null);
    }

    @Test
    public void givenHotelList_ShouldReturnCheapestHotelInGivenDateRange() {
        hotelReservationMain.hotelList.add(new Hotel("Oberoi", 10000, "2020-01-25", "2020-01-26"));
        hotelReservationMain.hotelList.add(new Hotel("Taj Palace", 6000, "2020-02-12", "2020-02-14"));
        hotelReservationMain.hotelList.add(new Hotel("Ashoka", 9000, "2020-11-01", "2020-11-04"));
        Hotel cheapestHotel = hotelReservationMain.findCheapestHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Taj Palace", cheapestHotel.hotelName);
    }

    @Test
    public void givenWeekendWeekdayRates_WhenHotelCreated_ShouldNotBeNull() {
        Hotel hotel1 = new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26");
        Hotel hotel2 = new Hotel("Taj Palace", 6000, 10000, "2020-02-12", "2020-02-14");
        Hotel hotel3 = new Hotel("Ashoka", 9000, 9500, "2020-11-01", "2020-11-04");
        Assert.assertNotNull(hotel1);
        Assert.assertNotNull(hotel2);
        Assert.assertNotNull(hotel3);
    }

    @Test
    public void givenHotelList_WhenCheapestByWeekendAndWeekdayRatesFound_ShouldReturntrue() {
        hotelReservationMain.hotelList.add(new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26"));
        hotelReservationMain.hotelList.add(new Hotel("Taj Palace", 6000, 10000, "2020-02-12", "2020-02-14"));
        hotelReservationMain.hotelList.add(new Hotel("Ashoka", 9000, 9500, "2020-11-01", "2020-11-04"));
        Hotel cheapestHotelByWeekdayRates = hotelReservationMain.findCheapestHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Hotel cheapestHotelByWeekendRates = hotelReservationMain.findCheapestHotelByWeekendRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Taj Palace", cheapestHotelByWeekdayRates.hotelName);
        Assert.assertEquals("Ashoka", cheapestHotelByWeekendRates.hotelName);
    }

    @Test
    public void givenDetailsIncludingRatings_WhenHotelObjectCreated_ShouldNotBeNull() {
        Hotel hotel = new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26", 4);
        Assert.assertNotNull(hotel);
    }

    @Test
    public void givenHotelList_WhenCheapestBestRatedHotelInGivenDateRangeFound_ShouldBeTrue() {
        hotelReservationMain.hotelList.add(new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26", 4));
        hotelReservationMain.hotelList.add(new Hotel("Taj Palace", 6000, 10000, "2020-02-12", "2020-02-14", 3));
        hotelReservationMain.hotelList.add(new Hotel("Ashoka", 6000, 9500, "2020-11-01", "2020-11-04", 4));
        Hotel cheapestBestRatedHotel = hotelReservationMain.findCheapestBestRatedHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Ashoka", cheapestBestRatedHotel.hotelName);
    }

    @Test
    public void givenHotelList_WhenBestRatedHotelFound_ShouldBeTrue() {
        hotelReservationMain.hotelList.add(new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26", 4));
        hotelReservationMain.hotelList.add(new Hotel("Taj Palace", 6000, 10000, "2020-02-12", "2020-02-14", 3));
        hotelReservationMain.hotelList.add(new Hotel("Ashoka", 6000, 9500, "2020-11-01", "2020-11-04", 4));
        Hotel cheapestBestRatedHotel = hotelReservationMain.findCheapestBestRatedHotelByWeekdayRates("2020-01-01", "2020-12-31");
        Assert.assertEquals("Ashoka", cheapestBestRatedHotel.hotelName);
    }

    @Test
    public void givenSpecialRates_WhenAddedToHotel_ShouldBeEqual() {
        Hotel hotel = new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26", 4);
        hotel.specialWeekdayRate = 9000;
        hotel.specialWeekendRate = 14000;
        Assert.assertEquals(9000, hotel.specialWeekdayRate, 0);
        Assert.assertEquals(14000, hotel.specialWeekendRate, 0);
    }

    @Test
    public void givenDate_WhenInvalid_ShouldThrowException() {
        try {
            String startDate = "2020/12/01";
            hotelReservationMain.validateDate(startDate);
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(true);
        }
    }

    @Test
    public void givenCustomerType_WhenInvalid_ShouldThrowException() {
        try {
            String customerType = "Very Important";
            hotelReservationMain.validateCustomerType(customerType);
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(true);
        }
    }

    @Test
    public void givenHotelList_WhenCheapestBestRatedHotelInGivenDateRangeForRewardCustomerFound_ShouldBeTrue() {
        hotelReservationMain.hotelList.add(new Hotel("Oberoi", 10000, 15000, "2020-01-25", "2020-01-26", 4, 9000, 14000, "Reward"));
        hotelReservationMain.hotelList.add(new Hotel("Taj Palace", 6000, 10000, "2020-02-12", "2020-02-14", 3, 5000, 9000, "Reward"));
        hotelReservationMain.hotelList.add(new Hotel("Ashoka", 6000, 9500, "2020-11-01", "2020-11-04", 4, 5000, 9000, "Reward"));
        Hotel cheapestBestRatedHotelForRewardCustomers = hotelReservationMain.findCheapestBestRatedHotelByWeekdayRatesForRewardCustomers("2020-01-01", "2020-12-31");
        Assert.assertEquals("Ashoka", cheapestBestRatedHotelForRewardCustomers.hotelName);
    }
}