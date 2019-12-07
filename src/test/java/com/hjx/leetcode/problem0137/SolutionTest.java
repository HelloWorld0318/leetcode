package com.hjx.leetcode.problem0137;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void singleNumber() {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 2};
        int ans = solution.singleNumber(nums);
        Assert.assertEquals(3, ans);
    }
}