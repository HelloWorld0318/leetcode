package com.hjx.leetcode.problem0081;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void search() {
        Solution solution = new Solution();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean ans = solution.search(nums, target);
        System.out.println(ans);
    }
}