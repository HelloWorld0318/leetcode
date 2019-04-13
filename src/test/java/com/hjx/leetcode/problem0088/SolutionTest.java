package com.hjx.leetcode.problem0088;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
    }
}