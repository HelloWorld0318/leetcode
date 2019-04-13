package com.hjx.leetcode.problem0502;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMaximizedCapital() {
        Solution solution = new Solution();
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1,};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital));
    }
}