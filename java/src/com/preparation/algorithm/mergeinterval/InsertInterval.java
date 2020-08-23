package com.preparation.algorithm.mergeinterval;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultedArray = new LinkedList();
        boolean newAdded = false;
        int remaining = intervals.length;

        for (int i = 0; i < intervals.length; i++) {

            int start1 = intervals[i][0];
            int end1 = intervals[i][1];
            int start2 = newInterval[0];
            int end2 = newInterval[1];

            //collision
            if ((start1 >= start2 && start1 <= end2) || (start2 >= start1 && start2 <= end1)) {
                newInterval[0] = Math.min(start1, start2);
                newInterval[1] = Math.max(end1, end2);
            } else {
                if (start1 < start2 && end1 < end2) {
                    //current interval
                    resultedArray.add(intervals[i]);
                } else {
                    //insertion of new
                    resultedArray.add(newInterval);
                    newAdded = true;
                    remaining = i;
                    break;
                }
            }
        }

        //remaining values greater than new interval will be added as it is
        for (int i = remaining; i < intervals.length; i++) {
            resultedArray.add(intervals[i]);
        }

        if (!newAdded) {
            resultedArray.add(newInterval);
        }

        //converting stack to int[][]
        int[][] ans = new int[resultedArray.size()][2];
        int j = 0;
        for (int[] arr : resultedArray) {
            ans[j++] = arr;
        }
        return ans;
    }
}
