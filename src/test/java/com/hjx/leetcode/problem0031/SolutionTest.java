package com.hjx.leetcode.problem0031;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void nextPermutation() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}