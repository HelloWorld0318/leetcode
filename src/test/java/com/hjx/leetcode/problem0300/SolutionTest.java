package com.hjx.leetcode.problem0300;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void lengthOfLIS() {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = solution.lengthOfLIS(nums);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void lengthOfLIS2() {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = solution.lengthOfLIS2(nums);
        Assert.assertEquals(result, 4);
    }
}