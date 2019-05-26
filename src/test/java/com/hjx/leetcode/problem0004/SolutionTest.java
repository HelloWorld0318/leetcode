package com.hjx.leetcode.problem0004;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMedianSortedArrays() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medium = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medium);
    }
}