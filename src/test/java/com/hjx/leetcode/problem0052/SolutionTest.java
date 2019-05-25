package com.hjx.leetcode.problem0052;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void totalNQueens() {
        Solution solution = new Solution();
        int queenCount = 4;
        int result = solution.totalNQueens(queenCount);
        Assert.assertEquals(result, 2);
    }
}