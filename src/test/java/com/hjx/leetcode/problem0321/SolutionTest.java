package com.hjx.leetcode.problem0321;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxNumber() {
        Solution solution = new Solution();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] result = solution.maxNumber(nums1, nums2, k);
        Arrays.stream(result).forEach(System.out::print);
    }
}