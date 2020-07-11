package com.preparation.leetcode.thirtyday.challenge.dayone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> records = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (records.containsKey(s)) {
                records.get(s).add(word);
            } else {
                List<String> strList = new LinkedList();
                strList.add(word);
                records.put(s, strList);
            }


        }

        List<List<String>> result = new LinkedList();
        for (String key : records.keySet()) {
            result.add(records.get(key));
        }

        return result;

    }

    public static void main(String[] s) {
        String[] sample = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams a = new GroupAnagrams();
        a.groupAnagrams(sample);
        for (int i = 0; i < sample.length; i++) {
            System.out.print(sample[i] +
                    " ");
        }
    }
}
