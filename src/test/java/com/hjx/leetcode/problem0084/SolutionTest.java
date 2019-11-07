package com.hjx.leetcode.problem0084;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void largestRectangleArea() {
        Solution solution = new Solution();
        int[] heights = {1, 1};
        int result = solution.largestRectangleArea(heights);
        Assert.assertEquals(2, result);
    }
}