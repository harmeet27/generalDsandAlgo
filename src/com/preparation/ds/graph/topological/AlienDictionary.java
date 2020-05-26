package com.preparation.ds.graph.topological;
/**
 * The first line contains t, the number of test cases. Then t test cases follow. Each test case has the following form:
 * -The first line contains n, the number of words.
 * -Then n lines follow, each line contains a word from dictionary
 */

import java.util.*;

public class AlienDictionary {

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int size = scanner.nextInt();
            String[] input = new String[size];
            int i = 0;
            while (i < size) {
                input[i] = scanner.next();
                i++;
            }
            System.out.println(findAlienDictionaryOrder(input));
            testCases--;
        }
    }

    private static String findAlienDictionaryOrder(String[] input) {

        HashMap<Character, Set<Character>> adjList = new HashMap<>();
        //inDegree to get the edges coming to each node
        int[] inDegree = new int[26];  //i-'a'  --> will give you the pos of char as per 0 based indexing
        buildGraphAdjList(input, adjList, inDegree);
        return performTopologicalSortingUsingBFS(adjList, inDegree);
    }

    private static void buildGraphAdjList(String[] input, HashMap<Character, Set<Character>> adjList, int[] inDegree) {
        for (String word : input) {
            for (Character c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < input.length; i++) {
//            for (int j = i + 1; j < input.length; j++) {
            String first = input[i - 1];
            String second = input[i];
            int len = Math.min(first.length(), second.length());
            for (int k = 0; k < len; k++) {
                if (first.charAt(k) != second.charAt(k)) {
                    //out means from node
                    //in means to node
                    //edge is creating
                    char out = first.charAt(k);
                    char in = second.charAt(k);
                    if (!adjList.get(out).contains(in)) {
                        adjList.get(out).add(in);
                        //add indegree to char in
                        inDegree[in - 'a'] += 1;
                    }
                    break;
                }

            }
        }

    }

    private static String performTopologicalSortingUsingBFS(HashMap<Character, Set<Character>> adjList,
                                                            int[] inDegree) {
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        //add all nodes which have inDegree of 0 to queue.
        List<Character> ch = findNodeWithDegree0(inDegree, adjList);
        queue.addAll(ch);

        while (!queue.isEmpty()) {
            char element = queue.poll();
            builder.append(element);
            if (adjList.get(element) == null || adjList.get(element).size() == 0) {
                continue;
            }
            for (Character value : adjList.get(element)) {
                inDegree[value - 'a']--;
                if (inDegree[value - 'a'] == 0) {
                    queue.offer(value);
                }
            }
        }
        return builder.toString().length() == adjList.size() ? builder.toString() : "INVALID";
    }

    private static List<Character> findNodeWithDegree0(int[] inDegree, HashMap<Character, Set<Character>> adjList) {
        List<Character> chList = new LinkedList<>();
        for (Character i : adjList.keySet()) {
            if (inDegree[i - 'a'] == 0) {
                chList.add(i);
            }
        }
        return chList;
    }
    /**
     *
     * Time complexity:
     * Say the number of characters in the dictionary (including duplicates) is n. Building the graph takes O(n). Topological sort takes O(V + E). V <= n. E also can't be larger than n. So the overall time complexity is O(n).
     *
     *
     *
     * Note:
     * You may assume all letters are in lowercase.
     * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
     * If the order is invalid, return an empty string.
     * There may be multiple valid order of letters, return any one of them is fine.
     *
     * Thought process:
     * Topological sort:
     * Build graph:
     *      a map of character -> set of character.
     *      Also get in-degrees for each character. In-degrees will be a map of character -> integer.
     *
     * Topological sort:
     *      Loop through in-degrees. Offer the characters with in-degree of 0 to queue.
     *
     *      While queue is not empty:
     *          Poll from queue. Append to character to result string.
     *          Decrease the in-degree of polled character's children by 1.
     *          If any child's in-degree decreases to 0, offer it to queue.
     *
     *      At last, if result string's length is less than the number of vertices, that means there is a cycle in my graph. The order is invalid.
     *
     *
     *
     * Sample Input
     *
     * 4
     *
     * 3
     *
     * caa
     *
     * aaa
     *
     * aab
     *
     * 4
     *
     * daa
     *
     * aaa
     *
     * aba
     *
     * caa
     *
     * 5
     *
     * baa
     *
     * abcd
     *
     * abca
     *
     * cab
     *
     * cad
     *
     * 3
     *
     * aba
     *
     * bba
     *
     * aaa
     *
     * Sample Output
     *
     * c a b
     *
     * INVALID
     *
     * b d a c
     *
     * INVALID
     *
     * Explanation
     */
}
