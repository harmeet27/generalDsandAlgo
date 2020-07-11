package com.preparation.companywise.flipKar.model;

public class BookingSlot {

    private String day;
    private String startTime;
    private String endTime;


    public BookingSlot(String startTime, String endTime, String day) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }


    public String getEndTime() {
        return endTime;
    }

    public String getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        return this.startTime == startTime;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(startTime);
    }
}
