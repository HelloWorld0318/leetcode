package com.hjx.leetcode.problem0211;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordDictionaryTest {

    @Test
    public void addWord() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }
}