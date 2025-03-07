package com.hjx.leetcode.problem0581;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testFindUnsortedSubarray() {
        Solution solution = new Solution();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int res = solution.findUnsortedSubarray(nums);
        System.out.println(res);
    }
}