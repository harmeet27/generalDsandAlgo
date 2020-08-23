package com.preparation.ds.graph.topological;
/**
 * https://leetcode.com/problems/course-schedule-ii/
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousreSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];

        HashMap<Integer, List<Integer>> adjList = new HashMap();
        Queue<Integer> queue = new LinkedList();
        int[] topOrder = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int needed = prerequisites[i][1];
            int forNode = prerequisites[i][0];

            inDegree[forNode] += 1;

            if (adjList.containsKey(needed)) {
                adjList.get(needed).add(forNode);
            } else {
                List<Integer> vals = new LinkedList();
                vals.add(forNode);
                adjList.put(needed, vals);
            }
        }


        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int i = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            topOrder[i++] = poll;

            if (adjList.containsKey(poll)) {
                for (int j : adjList.get(poll)) {
                    inDegree[j] -= 1;

                    if (inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }

        }

        if (i == numCourses) {
            return topOrder;
        }

        return new int[0];

    }


}
