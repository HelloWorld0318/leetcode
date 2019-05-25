package com.hjx.leetcode.problem0241;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void diffWaysToCompute() {
        Solution solution = new Solution();
        String input = "2*3-4*5";
        List<Integer> ans = solution.diffWaysToCompute(input);
        System.out.println(ans);
    }
}