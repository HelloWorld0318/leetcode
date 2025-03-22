package com.hjx.leetcode.problem0718;


import org.junit.Test;

public class SolutionTest {

    @Test
    public void testFindLength() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        solution.findLength(nums1, nums2);
    }
}