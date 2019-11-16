package com.hjx.leetcode.problem0035;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void searchInsert() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int ans = solution.searchInsert(nums, 0);
        System.out.println(ans);
    }
}