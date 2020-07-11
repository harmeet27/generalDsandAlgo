package com.preparation.companywise.flipKar.model;

public class Booking {

    private long bookingId;
    private Vehicle vehicle;
    private BookingSlot bookingSlot;
    private double amount;

    public Booking(long bookingId, Vehicle vehicle, BookingSlot bookingSlot) {
        this.bookingId = bookingId;
        this.vehicle = vehicle;
        this.bookingSlot = bookingSlot;
    }

    public BookingSlot getBookingSlot() {
        return bookingSlot;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
