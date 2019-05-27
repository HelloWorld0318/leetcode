package com.hjx.leetcode.problem0120;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void minimumTotal() {
        Solution solution = new Solution();
        List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(2),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(6, 7, 8),
                Lists.newArrayList(4, 1, 8, 3));

        int result = 11;
        Assert.assertEquals(result, solution.minimumTotal(triangle));
    }
}