package com.hjx.leetcode.problem0046;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void permute() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> ans = solution.permute(nums);
        System.out.println(ans);
    }
}