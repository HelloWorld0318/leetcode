package com.hjx.leetcode.problem0015;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void threeSum() {
        Solution solution = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println(res);
    }


    @Test
    public void threeSum2() {
        Solution solution = new Solution();
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> res = solution.threeSum(nums, 0);
        System.out.println(res);
    }

}