package com.preparation.ds.tries;

import java.util.Map;

/**
 * We can keep additional data in tries depending on requirement
 */
public class TrieNode {
    public Character data;
    public Map<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode(Character data, Map<Character, TrieNode> children, boolean isEndOfWord) {
        this.data = data;
        this.children = children;
        this.isEndOfWord = isEndOfWord;
    }
}
