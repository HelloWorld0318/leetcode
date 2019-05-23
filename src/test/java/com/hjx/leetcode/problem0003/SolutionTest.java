package com.hjx.leetcode.problem0003;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        String str = "ww";
        int ans = solution.lengthOfLongestSubstring(str);
        Assert.assertEquals(1, ans);
    }
}