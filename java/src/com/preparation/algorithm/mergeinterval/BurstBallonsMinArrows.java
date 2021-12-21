package com.preparation.algorithm.mergeinterval;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/
 * <p>
 * sort the array by end time asc. Then find totalnonoverlapping (similar to meeting rooms)
 **/
public class BurstBallonsMinArrows {

    private int minShots(int[][] points) {

        int arrows = 1;
        int lastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];
            if (currStart <= lastEnd) {
                continue;
            } else {
                arrows++;
                lastEnd = currEnd;
            }

        }
        return arrows;
    }
}
