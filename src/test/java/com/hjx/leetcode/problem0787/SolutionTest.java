package com.hjx.leetcode.problem0787;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testFindCheapestPrice() {
        Solution solution = new Solution();
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int res = solution.findCheapestPrice(4, flights, src, dst, k);
        System.out.println(res);
    }
}