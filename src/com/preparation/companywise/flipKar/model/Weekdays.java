package com.preparation.companywise.flipKar.model;

public enum Weekdays {

    MONDAY("MODAY"), TUESDAY("TUESDAY"),

    WEDNESDAY("WEDNESDAY"), THURSDAY("THURSDAY"),

    FRIDAY("FRIDAY");

    private String weekday;

    Weekdays(String weekday) {
        weekday = weekday;
    }

    public String getWeekday() {
        return weekday;
    }
}
