package com.hjx.leetcode.problem0080;

import org.junit.Test;

import java.util.Arrays;


public class SolutionTest {

    @Test
    public void removeDuplicates() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}