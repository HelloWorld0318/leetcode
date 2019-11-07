package com.hjx.leetcode.problem0072;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void minDistanceRecursion() {
        Solution solution = new Solution();
        String str1 = "horse";
        String str2 = "ros";
        int result = solution.minDistanceRecursion(str1, str2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void minDistance() {
        Solution solution = new Solution();
        String str1 = "intention";
        String str2 = "execution";
        int result = solution.minDistance(str1, str2);
        Assert.assertEquals(5, result);
    }
}