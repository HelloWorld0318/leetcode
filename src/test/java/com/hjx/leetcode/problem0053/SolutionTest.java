package com.hjx.leetcode.problem0053;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxSubArray() {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        Assert.assertEquals(result, 6);
    }
}