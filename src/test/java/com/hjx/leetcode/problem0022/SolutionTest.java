package com.hjx.leetcode.problem0022;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void generateParenthesis() {
        Solution solution = new Solution();
        int n = 3;
        List<String> ans = solution.generateParenthesis(n);
        System.out.println(ans);
    }
}