package com.hjx.leetcode.problem0518;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testChange() {
        Solution solution = new Solution();
        int res = solution.change(5, new int[]{1, 2, 5});
        System.out.println(res);
    }
}