package com.hjx.leetcode.problem0354;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testMaxEnvelopes() {
        int[][] envelopes = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        Solution s = new Solution();
        s.maxEnvelopes(envelopes);
    }
}