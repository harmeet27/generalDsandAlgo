package com.preparation.ds.tries;

import java.util.HashMap;

/**
 * prefix based searching like phone directory
 * <p>
 * Time Complexity search/Insert: O(wordLength)
 * Space Complexity : O(WordLength*words);
 */
public class Tries {

    public TrieNode root;

    public Tries() {
        root = new TrieNode(null, new HashMap(), false);
    }

    public void add(String word) {

        char[] ch = word.toCharArray();
        TrieNode currentNode = root;
        for (int i = 0; i < ch.length; i++) {
            char character = ch[i];
            if (!currentNode.children.containsKey(i))
                currentNode.children.put(character, new TrieNode(character, new HashMap<>(), false));

            currentNode = currentNode.children.get(character);
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        char[] ch = word.toCharArray();
        TrieNode currentNode = root;
        boolean isFound = true;
        for (char character : ch) {
            if (currentNode.children.containsKey(character))
                currentNode = currentNode.children.get(character);
            else {
                isFound = false;
                break;
            }
        }

        return isFound;
    }

}
