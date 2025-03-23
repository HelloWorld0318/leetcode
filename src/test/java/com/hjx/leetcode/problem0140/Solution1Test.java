package com.hjx.leetcode.problem0140;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1Test {

    @Test
    public void testWordBreak() {
        Solution1 solution1 = new Solution1();
        List<String> words = Lists.newArrayList("cats", "dog", "sand", "and", "cat");
        List<String> result = solution1.wordBreak("catsanddog", words);
        System.out.println(Arrays.toString(result.toArray()));
    }
}