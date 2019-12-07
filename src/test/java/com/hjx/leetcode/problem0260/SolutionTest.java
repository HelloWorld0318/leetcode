package com.hjx.leetcode.problem0260;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void singleNumber() {
        int[] nums = {1, 2, 1, -3, 2, 5};
        Solution solution = new Solution();
        int[] ans = solution.singleNumber(nums);
        String str = Arrays.toString(ans);
        System.out.println(str);
    }
}