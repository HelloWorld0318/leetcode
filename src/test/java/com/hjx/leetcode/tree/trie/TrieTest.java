package com.hjx.leetcode.tree.trie;

        import com.google.common.collect.Lists;
        import org.junit.Test;

        import java.util.List;

        import static org.junit.Assert.*;

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