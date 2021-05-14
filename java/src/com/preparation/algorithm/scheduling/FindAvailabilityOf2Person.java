package com.preparation.algorithm.scheduling;

import java.util.LinkedList;
import java.util.List;

/**
 * HARD:
 * Clement
 * https://www.youtube.com/watch?v=3Q_oYDQ2whs
 * <p>
 * Imagine that you want to schedule a meeting of a certain duration with a
 * co-worker. You have access to your calendar and your co-worker's calendar
 * (both of which contain your respective meetings for the day, in the form of
 * [startTime, endTime]
 * <p>
 * <p>
 * Write a function that takes in your calendar, your daily bounds, your
 * co-worker's calendar, your co-worker's daily bounds, and the duration of the
 * meeting that you want to schedule, and that returns a list of all the time
 * blocks (in the form of startTime, endTime during which you could schedule the meeting.
 * <p>
 * Given calendar of 2 people is given in sorted order by startTime.
 * <p>
 * Calendar1:
 * [
 * ["9:00", "10:30"],
 * ["12:00", "13:00"],
 * ["16:00", "18:00"]
 * ]
 * <p>
 * DailyBounds1:
 * ["9:00", "20:00"]
 * <p>
 * Calendar2:
 * [
 * ["10:00", "11:30"],
 * ["12:30", "14:30"],
 * ["14:30", "15:00"],
 * ["16:00", "17:00"]
 * ]
 * <p>
 * dailyBounds2:
 * ["10:00", "18:30"]
 * <p>
 * meetingDuration: 30
 * <p>
 * Output:
 * [['11:30', '12:00'], ['15:00', '16:00'], ['18:00', '18:30']]
 */
public class FindAvailabilityOf2Person {

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        return new LinkedList<>();
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
