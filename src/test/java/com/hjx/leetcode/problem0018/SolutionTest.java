package com.hjx.leetcode.problem0018;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void fourSum() {
        Solution solution = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution.fourSum(nums, target));
    }

    @Test
    public void fourSum2() {
        Solution solution = new Solution();
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(solution.fourSum2(nums, target));
    }
}