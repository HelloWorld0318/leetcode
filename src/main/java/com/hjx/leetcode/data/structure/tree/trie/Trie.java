package com.hjx.leetcode.data.structure.tree.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houjinxiang
 */
public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word != null && word.length() > 0) {
            TrieNode cur = root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!cur.children.containsKey(charArray[i])) {
                    return false;
                }
                cur = cur.children.get(charArray[i]);
            }
            return cur.isLeaf;
        }
        return false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word != null && word.length() > 0) {
            TrieNode cur = root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (!cur.children.containsKey(charArray[i])) {
                    TrieNode node = new TrieNode(charArray[i]);
                    cur.children.put(charArray[i], node);
                }
                cur = cur.children.get(charArray[i]);
            }
            cur.isLeaf = true;
        }
    }


    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix != null && prefix.length() > 0) {
            TrieNode cur = root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!cur.children.containsKey(charArray[i])) {
                    return false;
                }
                cur = cur.children.get(charArray[i]);
            }
            return true;
        }
        return false;
    }

    /**
     * 获取Trie树全部单词(存储路径，记录遍历的路径上面的节点)
     */
    public void getAllWordFromTrie(TrieNode trieNode, StringBuilder word,
                                   List<String> arrayListWord) {
        if (trieNode != null) {
            for (Map.Entry<Character, TrieNode> entry : trieNode.children.entrySet()) {
                word.append(entry.getKey());
                if (entry.getValue().isLeaf) {
                    arrayListWord.add(word.toString());
                }
                getAllWordFromTrie(entry.getValue(), word, arrayListWord);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    public void preOrderTrie(TrieNode node, int layer) {
        if (node != null) {
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                for (int i = 0; i < layer; i++) {
                    System.out.print("---");
                }
                System.out.print(entry.getKey());
                if (entry.getValue().isLeaf) {
                    System.out.print("(end)");
                }
                System.out.println();
                preOrderTrie(entry.getValue(), layer + 1);
            }
        }
    }

    private class TrieNode {

        /**
         * 当前节点的字符值
         */
        public char ch;

        /**
         * 当前节点的孩子节点，key是孩子节点值,value是孩子节点的下一个字典树
         */
        public Map<Character, TrieNode> children = new HashMap<>();

        /**
         * 是否是叶子节点
         */
        public boolean isLeaf;

        public TrieNode(char ch) {
            this.ch = ch;
            isLeaf = false;
        }

        public TrieNode() {
            isLeaf = false;
        }
    }
}
