package com.hjx.leetcode.problem0407;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void trapRainWater() {
        Solution solution = new Solution();
        int[][] heightMap = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        int ans = solution.trapRainWater(heightMap);
        System.out.println(ans);
    }
}