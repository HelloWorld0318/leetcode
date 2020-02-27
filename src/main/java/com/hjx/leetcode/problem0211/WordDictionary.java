package com.hjx.leetcode.problem0211;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public class WordDictionary {

    private static final int TRIE_MAX_CHAR_NUM = 26;

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word != null && word.length() > 0) {
            return search(root, word);
        }
        return false;
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isEnd;
        }
        if (word.charAt(0) == '.') {
            // 遍历当前节点的所有孩子
            for (int i = 0; i < TRIE_MAX_CHAR_NUM; i++) {
                if (root.child[i] != null && search(root.child[i], word.substring(1))) {
                    return true;
                }
            }
        } else {
            // 遍历当前节点指定的节点
            int index = word.charAt(0) - 'a';
            if (root.child[index] != null && search(root.child[index], word.substring(1))) {
                return true;
            }
        }
        return false;
    }

    class TrieNode {

        public TrieNode[] child;
        public boolean isEnd;

        public TrieNode() {
            child = new TrieNode[TRIE_MAX_CHAR_NUM];
            isEnd = false;
        }
    }
}
