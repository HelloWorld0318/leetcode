package com.hjx.leetcode.problem0315;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void countSmaller() {
        Solution solution = new Solution();
        int[] nums = {5, -7, 9, 1, 3, 5, -2, 1};
        List<Integer> ans = solution.countSmaller(nums);
        // ans = [5, 0, 5, 1, 2, 2, 0, 0]
        System.out.println(ans);
    }
}