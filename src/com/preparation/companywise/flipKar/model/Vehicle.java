package com.preparation.companywise.flipKar.model;

import java.util.HashMap;

public abstract class Vehicle {

    protected int basePrice = 100;
    protected HashMap<String, HashMap<BookingSlot, Boolean>> bookingSlots;

    protected String vehicleType;

    public String getVehicleType() {
        return vehicleType;
    }

    public Vehicle() {
        bookingSlots = new HashMap<>();
        populateBookingSlots();
    }

    public HashMap<String, HashMap<BookingSlot, Boolean>> getBookingSlots() {
        return bookingSlots;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public abstract double getPrice();


    private void populateBookingSlots() {
        Weekdays[] days = Weekdays.values();
        for (Weekdays day : days) {
            HashMap<BookingSlot, Boolean> bookings = new HashMap<>();
            bookings.put(new BookingSlot("00", "01", day.getWeekday()), false);
            bookings.put(new BookingSlot("01", "02", day.getWeekday()), false);
            bookings.put(new BookingSlot("03", "04", day.getWeekday()), false);
            bookings.put(new BookingSlot("05", "06", day.getWeekday()), false);
            bookings.put(new BookingSlot("07", "08", day.getWeekday()), false);
            bookings.put(new BookingSlot("08", "09", day.getWeekday()), false);
            bookings.put(new BookingSlot("08", "09", day.getWeekday()), false);
            bookings.put(new BookingSlot("09", "10", day.getWeekday()), false);
            bookings.put(new BookingSlot("10", "11", day.getWeekday()), false);
            bookings.put(new BookingSlot("11", "12", day.getWeekday()), false);
            bookings.put(new BookingSlot("12", "13", day.getWeekday()), false);
            bookings.put(new BookingSlot("13", "14", day.getWeekday()), false);
            bookings.put(new BookingSlot("14", "15", day.getWeekday()), false);
            bookings.put(new BookingSlot("15", "16", day.getWeekday()), false);
            bookings.put(new BookingSlot("16", "17", day.getWeekday()), false);
            bookings.put(new BookingSlot("17", "18", day.getWeekday()), false);
            bookings.put(new BookingSlot("18", "19", day.getWeekday()), false);
            bookings.put(new BookingSlot("19", "20", day.getWeekday()), false);
            bookings.put(new BookingSlot("20", "21", day.getWeekday()), false);
            bookings.put(new BookingSlot("21", "22", day.getWeekday()), false);
            bookings.put(new BookingSlot("22", "23", day.getWeekday()), false);
            bookings.put(new BookingSlot("23", "24", day.getWeekday()), false);

            bookingSlots.put(day.getWeekday(), bookings);
        }


    }
}
