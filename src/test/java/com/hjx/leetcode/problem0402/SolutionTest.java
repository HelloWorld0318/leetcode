package com.hjx.leetcode.problem0402;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void removeKdigits() {
        Solution solution = new Solution();
        String num = "10200";
        int k = 1;
        System.out.println(solution.removeKdigits(num, k));
    }
}