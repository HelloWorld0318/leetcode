package com.hjx.leetcode.problem0001;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void twoSum() {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(result);
    }
}