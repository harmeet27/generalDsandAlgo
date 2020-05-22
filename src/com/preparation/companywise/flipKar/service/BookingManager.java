package com.preparation.companywise.flipKar.service;

import com.preparation.companywise.flipKar.model.*;

import java.util.HashMap;
import java.util.List;

public class BookingManager {

    private HashMap<String, List<Booking>> bookings; //moday bookings

    private HashMap<String, List<Vehicle>> availableVehicles; // type and vehicles

    //

    private long totalBookings = 0;

    BookingManager() {
        bookings = new HashMap<>();
        availableVehicles = new HashMap<>();
    }

    public Booking createBooking(String vehicleType, BookingSlot timeSlot, Weekdays day) {

        Vehicle vehicle = null;
        Booking newBooking = null;
        if (availableVehicles.get(vehicleType).size() > 1) {
            List<Vehicle> vehicles = availableVehicles.get(vehicleType);
            for (Vehicle vehicle1 : vehicles) {
                HashMap<BookingSlot, Boolean> slots = vehicle1.getBookingSlots().get(day);

                if (slots.get(timeSlot) == false) {
                    slots.put(timeSlot, true);
                    newBooking = new Booking(totalBookings + 1, vehicle1, timeSlot);
                    break;
                }

            }
        }
        if (newBooking == null) {
            throw new RuntimeException("Slot is not empty for the provided vehicle type.");
        }
        return newBooking;
    }

    public boolean cancelBooking(Booking booking) {
        List<Booking> perDayBooking = bookings.get(booking.getBookingSlot().getDay());

        HashMap<String, HashMap<BookingSlot, Boolean>> slots = booking.getVehicle().getBookingSlots();

        HashMap<BookingSlot, Boolean> bookingSlot = booking.getVehicle().getBookingSlots().get(booking.getBookingSlot().getDay());

        //marked the car available for this slot
        bookingSlot.put(booking.getBookingSlot(), false);
        List<Vehicle> vehicles = availableVehicles.get(booking.getVehicle().getVehicleType());
        return vehicles.add(booking.getVehicle());


    }

}
