package com.cg.workshop;
public class Hotel {
    public String hotelName;
    public double rate;
    public String startDate;
    public String endDate;
    public double weekdayRate;
    public double weekendRate;
    public int rating;
    public double specialWeekdayRate;
    public double specialWeekendRate;
    public String customerType = "Regular";

    public Hotel(String hotelName, int weekdayRate) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.startDate = " ";
        this.endDate = " ";
        this.weekdayRate = weekdayRate;
        this.weekendRate = 0;
        this.rating = 0;
    }
    public Hotel(String hotelName, double weekdayRate, String startDate, String endDate){
        this.weekendRate = 0;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = 0;
    }

    public Hotel(String hotelName, double weekdayRate, double weekendRate, String startDate, String endDate, int rating) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
    }
    public Hotel(String hotelName, double weekdayRate, double weekendRate, String startDate, String endDate){
        this.weekendRate = weekendRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = 0;
    }
    public Hotel(String hotelName, double weekdayRate, double weekendRate, String startDate, String endDate, int rating, double specialWeekdayRate, double specialWeekendRate, String customerType) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.specialWeekdayRate = specialWeekdayRate;
        this.specialWeekendRate = specialWeekendRate;
        this.customerType = customerType;
    }
    public boolean validate() {
        HotelReservationMain hotelReservationMain = new HotelReservationMain();
        try {
            return hotelReservationMain.validateDate(this.startDate) &&
                    hotelReservationMain.validateDate(this.endDate) &&
                    hotelReservationMain.validateCustomerType(customerType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}