package com.hjx.leetcode.problem0139;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Solution1Test {

    @Test
    public void testWordBreak() {
        Solution1 s = new Solution1();
        List<String> words = Lists.newArrayList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        Assert.assertTrue(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", words));
    }

    @Test
    public void testCase2() {
        Solution1 solution1 = new Solution1();
        List<String> words = Lists.newArrayList("cats", "dog", "sand", "and", "cat");
        Assert.assertFalse(solution1.wordBreak("catsandog", words));
    }
}