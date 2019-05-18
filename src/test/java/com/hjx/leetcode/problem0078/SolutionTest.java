package com.hjx.leetcode.problem0078;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subsets() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = solution.subsets(nums);
        System.out.println(ans);
    }
}