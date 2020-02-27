package com.hjx.leetcode.problem0208;

public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word != null && word.length() > 0) {
            TrieNode cur = root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'a';
                if (cur.child[index] == null) {
                    cur.child[index] = new TrieNode();
                }
                cur = cur.child[index];
            }
            cur.isEnd = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word != null && word.length() > 0) {
            TrieNode cur = root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'a';
                if (cur.child[index] == null) {
                    return false;
                }
                cur = cur.child[index];
            }
            return cur.isEnd;
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix != null && prefix.length() > 0) {
            TrieNode cur = root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'a';
                if (cur.child[index] == null) {
                    return false;
                }
                cur = cur.child[index];
            }
            return true;
        }
        return true;
    }

    class TrieNode {
        private static final int TRIE_MAX_CHAR_NUM = 26;

        public TrieNode[] child;
        public boolean isEnd;

        public TrieNode() {
            child = new TrieNode[TRIE_MAX_CHAR_NUM];
            isEnd = false;
        }
    }
}

