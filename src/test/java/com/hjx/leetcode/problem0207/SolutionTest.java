package com.hjx.leetcode.problem0207;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void canFinishDfsMethod() {
        Solution solution = new Solution();
        int[][] prerequisites = {
                {1, 0}
        };

        boolean ans = solution.canFinishDfsMethod(2, prerequisites);
        System.out.println(ans);
    }

    @Test
    public void canFinish() {
        Solution solution = new Solution();
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
        };
        boolean ans = solution.canFinish(2, prerequisites);
        System.out.println(ans);
    }
}