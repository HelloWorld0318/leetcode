package com.hjx.leetcode.tree.trie;

import com.google.common.collect.Lists;
import com.hjx.leetcode.data.structure.tree.trie.Trie;
import org.junit.Test;

import java.util.List;

public class TrieTest {

    @Test
    public void preOrderTrie() {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abd");
        trie.insert("b");
        trie.insert("bcd");
        trie.insert("efg");

        trie.preOrderTrie(trie.root, 0);

        StringBuilder stringBuilder = new StringBuilder();
        List<String> allWords = Lists.newArrayList();

        trie.getAllWordFromTrie(trie.root, stringBuilder, allWords);
        System.out.println(allWords);
    }
}