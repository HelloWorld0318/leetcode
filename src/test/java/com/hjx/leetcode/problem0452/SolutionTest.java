package com.hjx.leetcode.problem0452;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testFindMinArrowShots() {
        Solution solution = new Solution();
        int[][] nums = {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        int res = solution.findMinArrowShots(nums);
        Assert.assertEquals(2, res);
    }
}