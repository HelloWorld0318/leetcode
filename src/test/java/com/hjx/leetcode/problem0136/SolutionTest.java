package com.hjx.leetcode.problem0136;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void singleNumber() {
        Solution solution = new Solution();
        int[] nums = {4,1,2,1,2};
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}