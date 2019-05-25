package com.hjx.leetcode.problem0029;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void divide() {
        Solution solution = new Solution();
        int devidend = -2147483648;
        int devisor = -1;
        int result = solution.divide(devidend, devisor);
        Assert.assertEquals(-2147483648, result);
    }
}