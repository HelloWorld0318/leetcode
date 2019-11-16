package com.hjx.leetcode.problem0033;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void search() {
        Solution solution = new Solution();
        int[] nums = {3, 1};
        int target = 1;
        int ans = solution.search(nums, target);
        System.out.println(ans);
    }
}