package com.hjx.leetcode.problem0208;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void insert() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
    }

}