package com.hjx.leetcode.problem0079;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testExist() {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean res = solution.exist(board, word);
        Assert.assertTrue(res);
    }
}