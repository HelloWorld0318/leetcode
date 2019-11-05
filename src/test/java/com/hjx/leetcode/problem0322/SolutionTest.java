package com.hjx.leetcode.problem0322;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void coinChange() {
        Solution solution = new Solution();
        int[] coins = {2};
        int amount = 2;
        int result = solution.coinChange(coins, amount);
        System.out.println(result);
    }
}