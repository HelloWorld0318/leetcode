package com.hjx.leetcode.problem0388;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testLengthLongestPath() {
        Solution solution = new Solution();
        String input = "a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt";
        int res = solution.lengthLongestPath(input);
        Assert.assertEquals(14, res);
    }
}