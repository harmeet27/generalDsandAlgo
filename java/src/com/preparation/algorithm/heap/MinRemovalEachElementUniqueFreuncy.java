package com.preparation.algorithm.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 * https://www.geeksforgeeks.org/minimum-characters-required-to-be-removed-to-make-frequency-of-each-character-unique/
 */
public class MinRemovalEachElementUniqueFreuncy {

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
            Integer peek = queue.peek();
            if (lastCount != peek) {
                lastCount = queue.poll();
            } else {
                removal++;
                int current = queue.poll();
                if (current - 1 > 0) queue.add(current - 1);
            }
        }
        return removal;
    }
}
