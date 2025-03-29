package com.hjx.leetcode.problem0005;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testLongestPalindrome() {
        Solution solution = new Solution();
        String res = solution.longestPalindrome("abb");
        Assert.assertEquals(res, "bb");
    }
}