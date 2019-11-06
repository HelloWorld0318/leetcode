package com.hjx.leetcode.problem0062;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void uniquePaths() {
        Solution solution = new Solution();
        int m = 7;
        int n = 3;
        int result = solution.uniquePaths(m, n);
        Assert.assertEquals(result, 28);
    }

}