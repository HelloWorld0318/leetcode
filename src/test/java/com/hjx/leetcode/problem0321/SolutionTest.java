package com.hjx.leetcode.problem0321;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void maxArray() {
        Solution solution = new Solution();
        // output [9, 8, 6, 5, 3]
        int[] nums1 = {3, 4};
        int[] nums2 = {};
        int k = 2;
        int[] result = solution.maxNumber(nums1, nums2, k);
        Arrays.stream(result).forEach(System.out::print);
        System.out.println();
    }
}