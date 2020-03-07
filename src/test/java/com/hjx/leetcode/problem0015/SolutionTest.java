package com.hjx.leetcode.problem0015;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void threeSum() {
        Solution solution = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);
    }
}