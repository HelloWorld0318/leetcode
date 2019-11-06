package com.hjx.leetcode.problem0063;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void uniquePathsWithObstacles() {
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]{
                {0}
        };
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        Assert.assertEquals(result, 6);
    }
}