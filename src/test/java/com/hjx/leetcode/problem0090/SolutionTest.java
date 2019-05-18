package com.hjx.leetcode.problem0090;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void subsetsWithDup() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        System.out.println(ans);
    }
}