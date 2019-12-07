package com.hjx.leetcode.problem0290;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void wordPattern() {
        Solution solution = new Solution();
        String pattern = "abba";
        String str = "dog dog dog dog";
        boolean ans = solution.wordPattern(pattern, str);
        System.out.println(ans);
    }
}
