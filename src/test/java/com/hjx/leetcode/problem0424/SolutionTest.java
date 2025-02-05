package com.hjx.leetcode.problem0424;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void longestPalindrome() {
        Solution solution = new Solution();
        String str = "AABABBA";
        int k = 1;
        int ans = solution.characterReplacement(str, k);
        System.out.println(ans);
        Assert.assertEquals(ans, 4);
    }
}