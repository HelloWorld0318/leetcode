package com.hjx.leetcode.problem0215;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findKthLargest() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(solution.findKthLargest(nums, k));
    }
}