package com.hjx.leetcode.problem0085;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maximalRectangle() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Solution solution = new Solution();
        int result = solution.maximalRectangle(matrix);
        Assert.assertEquals(6, result);
    }
}