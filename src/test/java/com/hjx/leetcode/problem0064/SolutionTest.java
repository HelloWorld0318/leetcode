package com.hjx.leetcode.problem0064;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minPathSum() {
        Solution solution = new Solution();
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        int result = solution.minPathSum(grid);
        Assert.assertEquals(result, 7);
    }
}