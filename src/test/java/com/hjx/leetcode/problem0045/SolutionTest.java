package com.hjx.leetcode.problem0045;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testJump() {
        int[] nums = {2, 0, 2, 4, 6, 0, 0, 3};
        Solution solution = new Solution();
        int res = solution.jump(nums);
        System.out.println(res);
    }

    @Test
    public void testJump1() {
        int[] nums = {2, 3, 0, 1, 4};
        Solution solution = new Solution();
        int res = solution.jump(nums);
        System.out.println(res);
    }

    @Test
    public void testJump2() {
        int[] nums = {2, 3, 0, 1, 4};
        Solution solution = new Solution();
        int res = solution.jump(nums);
        System.out.println(res);
    }
}