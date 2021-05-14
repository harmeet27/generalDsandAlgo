package com.preparation.algorithm.scheduling;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Station scheduling can work here
 * https://blog.usejournal.com/minimum-platforms-hackerrank-f86ed28d3a50
 */
public class MeetingRoomScheduling {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // sort the arrays by start time
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        // sort the heap by end time (scheduled meeting)
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, (a, b) -> a.end - b.end);
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval earliest = pq.peek();
            Interval curInterval = intervals[i];

            if (earliest.end <= curInterval.start) {
                earliest.end = curInterval.end; // merge (use the same room)
                //we can also poll and add this new curInterval if needed.
            } else {
                pq.offer(curInterval); // schedule a new room
            }
        }

        return pq.size();
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
