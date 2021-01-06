package com.preparation.algorithm.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Step 1: Add next item to one of the heaps
 *
 *    if next item is smaller than maxHeap root add it to maxHeap,
 *    else add it to minHeap
 *
 * Step 2: Balance the heaps (after this step heaps will be either balanced or
 *    one of them will contain 1 more item)
 *
 *    if number of elements in one of the heaps is greater than the other by
 *    more than 1, remove the root element from the one containing more elements and
 *    add to the other one
 * Then at any given time you can calculate median like this:
 *
 *    If the heaps contain equal amount of elements;
 *      median = (root of maxHeap + root of minHeap)/2
 *    Else
 *      median = root of the heap with more elements
 */
public class FindMedianInRunningStream {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    double median = 0;

    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.add(num);
            median = num;
            return;
        }

        if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        //check if they dont differ by length 2
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
            median = (minHeap.peek()+maxHeap.peek()*1.0)/2;
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
            median = (minHeap.peek()+maxHeap.peek()*1.0)/2;
        } else {
            //lastly calculate median
            if (minHeap.size() == maxHeap.size()) {
                median = (minHeap.peek() + maxHeap.peek())*1.0 / 2;
                System.out.println(median);
            } else if (minHeap.size() > maxHeap.size()) {
                median = minHeap.peek();
            } else {
                median = maxHeap.peek();
            }
        }


    }

    public double findMedian() {
        return median;
    }


    public static void main(String... s){
        FindMedianInRunningStream medianInRunningStream = new FindMedianInRunningStream();
        medianInRunningStream.addNum(-1);
        medianInRunningStream.addNum(-2);
        medianInRunningStream.addNum(-3);
        medianInRunningStream.addNum(-4);
        medianInRunningStream.addNum(-5);
        System.out.println(medianInRunningStream.findMedian());
    }
}
