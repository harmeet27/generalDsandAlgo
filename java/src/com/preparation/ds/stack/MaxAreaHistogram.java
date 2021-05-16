package com.preparation.ds.stack;

import java.util.Stack;

public class MaxAreaHistogram {

    //bruteForce o(n^2) and memory o(1)
    public int largestRectangleAreaBruteForce(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minElement = heights[i];
            int area = heights[i];
            maxArea = Math.max(maxArea, area);

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] == 0 || heights[j] == 0) {
                    break;
                }
                if (heights[j] < minElement)
                    minElement = heights[j];


                maxArea = Math.max(maxArea, minElement * (j - i + 1));

            }


        }

        return heights[heights.length - 1] > maxArea ? heights[heights.length - 1] : maxArea;
    }

    //with Stack o(n) space and time
    public int largestRectangleAreaWithStack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;

        Stack<Integer> stack = new Stack();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                //remove element index
                int height = heights[stack.pop()];

                //find prev index prior after removing the elemnt
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        //will use the prev i here to compute the remaining
        while (!stack.isEmpty()) {
            int currIndex = stack.pop();
            int height = heights[currIndex];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }


}
