package com.hjx.leetcode.problem0134;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void canCompleteCircuit() {
        Solution solution = new Solution();
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testCanCompleteCircuit2() {
        Solution solution = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit2(gas, cost));
    }
}