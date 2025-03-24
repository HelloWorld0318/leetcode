package com.hjx.leetcode.problem0494;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testFindTargetSumWays() {
        Solution solution = new Solution();
        int res = solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(res);
    }
}