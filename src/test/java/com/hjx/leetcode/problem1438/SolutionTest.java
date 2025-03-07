package com.hjx.leetcode.problem1438;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testLongestSubarray() {
        Solution solution = new Solution();
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        int res = solution.longestSubarray(nums, limit);
        Assert.assertEquals(4, res);
    }
}