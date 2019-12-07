package com.hjx.leetcode.problem0409;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestPalindrome() {
        Solution solution = new Solution();
        String str = "abbccccdd";
        int ans = solution.longestPalindrome(str);
        System.out.println(ans);
    }
}