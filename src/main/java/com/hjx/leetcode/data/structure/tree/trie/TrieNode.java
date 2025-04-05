package com.hjx.leetcode.data.structure.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树节点的数据结构
 */
public class TrieNode {

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
