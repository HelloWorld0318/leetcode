package com.hjx.leetcode.problem0918;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testMaxSubarraySumCircular() {
        Solution solution = new Solution();
        int[] nums = {1, -2, 3, -2};
        int res = solution.maxSubarraySumCircular(nums);
        System.out.println(res);
    }
}