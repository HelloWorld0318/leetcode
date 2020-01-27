package com.hjx.leetcode.problem0473;

import org.junit.Test;


public class SolutionTest {

    @Test
    public void makesquare() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 2};
        boolean ans = solution.makesquare(nums);
        System.out.println(ans);
    }

    @Test
    public void makesquareBitOperation() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 2};
        boolean ans = solution.makesquareBitOperation(nums);
        System.out.println(ans);
    }
}