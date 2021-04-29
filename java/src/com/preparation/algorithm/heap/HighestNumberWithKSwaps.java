package com.preparation.algorithm.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class HighestNumberWithKSwaps {
    public int minDeletions(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap();
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        map.forEach((k, v) -> queue.add(v));

        int removal = 0;
        int lastCount = -1;
        while (!queue.isEmpty()) {
            Integer removed = queue.poll();

            if (lastCount == 0) {
                removal = removal + removed;
                removed = 0;
            } else if (lastCount != -1) {
                if (removed >= lastCount) {
                    removal = removal + (removed - lastCount + 1);
                    removed = lastCount - 1;
                }
            }
            lastCount = removed;
        }

        return removal;

    }

}
