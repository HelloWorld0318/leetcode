package com.hjx.leetcode.problem0224;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void calculate() {
        Solution solution = new Solution();
        String s = "(1+(4+5+2)-3)+(6+8)";
        int result = solution.calculate(s);
        System.out.println(result);
    }
}