package com.preparation.algorithm.scheduling;

/**
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * Explantion: There are at-most three trains at a time (time between 11:00 to 11:20)
 * <p>
 * Approach1:
 * 1. Sort both the startTime array and endTIme array.
 * 2. NOw traverse both , such that picking up the samllest element first.
 * 3. If it is picked from arrival array , do +1.
 * 4. if from departure array perform -1;
 * 5. Maintain a record of max count encountered. That is the no of station needed.
 * <p>
 * time : 0(nlog(n))
 * space constant
 * <p>
 * <p>
 * Approach2 :
 * 1. Prepare a HashMap of train standing in one station with <station, trainDepartureTime>
 * 2. If a train that comes up, check in map if you have any station available meaning map.trainDepartureTime< current train.arrivalTime.
 * 3. If yes, add it in the same station and keep the count as it is.
 * 4. If not, add a new record in the map, with count++;
 * <p>
 * Time: o(n*k) where k is keys or stations in map for traversing
 * sspace : 0(n)
 *
 * Approach 3:
 * Use Heap
 *
 * https://blog.usejournal.com/minimum-platforms-hackerrank-f86ed28d3a50
 * *
 */
public class TrainStationScheduling {


}
