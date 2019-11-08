package com.hjx.leetcode.problem0547;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findCircleNumDfsMethod() {
        Solution solution = new Solution();
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result = solution.findCircleNumDfsMethod(M);
        Assert.assertEquals(2, result);
    }

    @Test
    public void findCircleNum() {
        Solution solution = new Solution();
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result = solution.findCircleNum(M);
        Assert.assertEquals(2, result);
    }

}