package com.hjx.leetcode.problem0128;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void longestConsecutiveMapMethod() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Solution solution = new Solution();
        int result = solution.longestConsecutiveMapMethod(nums);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void longestConsecutive() {
        int[] nums = {1, 1, 0, -1};
        Solution solution = new Solution();
        int result = solution.longestConsecutive(nums);
        Assert.assertEquals(result, 3);
    }

}