package com.hjx.leetcode.problem0174;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void calculateMinimumHP() {
        Solution solution = new Solution();
        int[][] dungeon = new int[3][3];
        dungeon[0] = new int[]{-2, -3, 3};
        dungeon[1] = new int[]{-5, -10, 1};
        dungeon[2] = new int[]{10, 30, -5};
        int result = solution.calculateMinimumHP(dungeon);
        Assert.assertEquals(result, 7);
    }
}