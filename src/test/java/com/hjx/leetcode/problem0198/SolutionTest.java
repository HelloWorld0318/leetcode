package com.hjx.leetcode.problem0198;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rob() {
        Solution solution = new Solution();
        int[] nums = {2,7,9,3,1};
        int result = solution.rob(nums);
        Assert.assertEquals(result,12);
    }
}