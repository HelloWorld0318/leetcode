package com.hjx.leetcode.problem0039;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void combinationSum() {
        Solution solution = new Solution();
        int[] candidate = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidate, target);
        System.out.println(result);
    }
}