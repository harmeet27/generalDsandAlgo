package com.preparation.algoexpert;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 You're looking to move into a new apartment on specific street, and you're
 given a list of contiguous blocks on that street where each block contains an
 apartment that you could move into.
 */
public class ApartmentHunting {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        //storing indexes maxIndex , and min Index from right
        List<Map<String, Integer>> fromLeft = new LinkedList();
        List<Map<String, Integer>> fromRight = new LinkedList();
        Map<String, Integer> distMap = new HashMap();
        for (String building : reqs) {
            distMap.put(building, Integer.MAX_VALUE);
        }
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Boolean> currentBlock = blocks.get(i);
            HashMap<String, Integer> currentBlockDist = new HashMap();
            for (String building : reqs) {
                if (currentBlock.get(building)) {
                    distMap.put(building, i);
                }
                currentBlockDist.putAll(distMap);
            }
            fromLeft.add(currentBlockDist);
        }

        for (String building : reqs) {
            distMap.put(building, Integer.MAX_VALUE);
        }

        for (int j = blocks.size() - 1; j >= 0; j--) {
            Map<String, Boolean> currentBlock = blocks.get(j);
            HashMap<String, Integer> currentBlockDist = new HashMap();
            for (String building : reqs) {
                if (currentBlock.get(building)) {
                    distMap.put(building, j);
                }
                currentBlockDist.putAll(distMap);
            }
            fromRight.add(currentBlockDist);
        }

        Collections.reverse(fromRight);

        int minDistance = Integer.MAX_VALUE;
        int minDistanceIndex = -1;
        for (int i = 0; i < fromLeft.size(); i++) {
            Map<String, Integer> currentBlockLeft = fromLeft.get(i);
            Map<String, Integer> currentBlockRight = fromRight.get(i);
            int maxDistance = Integer.MIN_VALUE;
            for (String building : reqs) {
                currentBlockLeft.put(building, Math.min(currentBlockLeft.get(building),
                        currentBlockRight.get(building)));
                int distance = Integer.MAX_VALUE;
                if (currentBlockLeft.get(building) != Integer.MAX_VALUE) {
                    distance = Math.abs(i - currentBlockLeft.get(building));
                }
                maxDistance = Math.max(distance, maxDistance);

            }

            if (maxDistance < minDistance) {
                minDistance = maxDistance;
                minDistanceIndex = i;
            }
        }

        return minDistanceIndex;
    }

    public static void main(String... s) {

        List<Map<String, Boolean>> data = new LinkedList<>();
        String[] reqs = {"gym", "school", "store"};


        Map<String, Boolean> data1 = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("school", true);
            put("store", false);
        }};

        Map<String, Boolean> data2 = new HashMap<String, Boolean>() {{
            put("gym", true);
            put("school", false);
            put("store", false);
        }};

        Map<String, Boolean> data3 = new HashMap<String, Boolean>() {{
            put("gym", true);
            put("school", true);
            put("store", false);
        }};

        Map<String, Boolean> data4 = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("school", true);
            put("store", false);
        }};

        Map<String, Boolean> data5 = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("school", true);
            put("store", true);
        }};

        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        data.add(data5);
        System.out.println(apartmentHunting(data, reqs));
    }
}
