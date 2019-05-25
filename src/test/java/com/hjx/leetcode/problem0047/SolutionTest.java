package com.hjx.leetcode.problem0047;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void permuteUnique() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2};
        List<List<Integer>> ans = solution.permuteUnique(nums);
        System.out.println(ans);
    }
}