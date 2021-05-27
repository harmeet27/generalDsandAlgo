package com.preparation.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder
 * 2 ways solved:
 * 1. Using meoization technique, I have as of now added recursive code which can be further translated to memo.
 * <p>
 * <p>
 * 2. Using BFS shortest path algorithm
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int minLength = findLadderLength(endWord, 0, beginWord, wordList);
//        if (minLength == Integer.MAX_VALUE)
//            return 0;
//        return minLength;

        return minLengthBFS(beginWord, endWord, wordList);
    }


    private int findLadderLengthMemoization(String endWord, int idx, String prevWord, List<String> wordList) {

        if (idx > wordList.size()) {
            return Integer.MAX_VALUE;
        }

        if (prevWord.equals(endWord)) {
            return 1;
        }


        int minTillNow = Integer.MAX_VALUE;
        for (int i = idx; i < wordList.size(); i++) {
            String currentWord = wordList.get(i);
            if (isValidLength(currentWord, prevWord)) {
                int total = findLadderLengthMemoization(endWord, i + 1, currentWord, wordList);
                if (total != Integer.MAX_VALUE) {
                    minTillNow = Math.min(minTillNow, total);
                }
            }
        }

        if (minTillNow != Integer.MAX_VALUE) {
            return 1 + minTillNow;
        }
        return minTillNow;

    }

    private int minLengthBFS(String beginWord, String endWord, List<String> words) {
        HashMap<String, List<String>> graph = buildGraph(beginWord, words);
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(new Node(beginWord, 0));
        Set<String> visited = new HashSet();
        while (!queue.isEmpty()) {
            Node traversed = queue.poll();
            if (traversed.word.equals(endWord)) {
                return traversed.length + 1;
            }

            if (visited.contains(traversed.word)) {
                continue;
            }

            visited.add(traversed.word);

            for (String child : graph.get(traversed.word)) {
                queue.add(new Node(child, traversed.length + 1));
            }

        }

        return 0;
    }

    private HashMap<String, List<String>> buildGraph(String beginWord, List<String> words) {
        HashMap<String, List<String>> graph = new HashMap();
        words.add(beginWord);
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            graph.put(currentWord, new ArrayList());
            for (int j = 0; j < words.size(); j++) {
                if (i != j && isValidLength(currentWord, words.get(j))) {
                    List<String> children = graph.get(currentWord);
                    children.add(words.get(j));
                    graph.put(currentWord, children);
                }
            }
        }

        return graph;

    }

    private boolean isValidLength(String word1, String word2) {
        boolean isValid = true;
        int diff = 0;
        int i = 0;
        while (i < word1.length()) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff += 1;
                if (diff > 1) {
                    isValid = false;
                    break;
                }
            }
            i++;
        }

        return isValid;
    }

    class Node {
        int length;
        String word;

        Node(String word, int length) {
            this.length = length;
            this.word = word;
        }
    }

    public static void main(String... s) {
        WordLadder wordLadder = new WordLadder();
        int length = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(length);
    }
}
