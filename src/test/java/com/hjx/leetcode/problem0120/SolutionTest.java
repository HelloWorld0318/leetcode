package com.hjx.leetcode.problem0120;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void minimumTotal() {
        Solution solution = new Solution();
        List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(-1),
                Lists.newArrayList(3, 2),
                Lists.newArrayList(-3, 1, -1));
        int result = -1;
        Assert.assertEquals(result, solution.minimumTotal(triangle));
    }
}