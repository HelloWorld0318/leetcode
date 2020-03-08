package com.hjx.leetcode.problem0089;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void grayCode() {
        Solution solution = new Solution();
        int n = 3;
        List<Integer> ans = solution.grayCode(n);
        System.out.println(ans);
    }
}