package com.hjx.leetcode.problem0455;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findContentChildren() {
        Solution solution = new Solution();
        int[] g = {1,2};
        int[] s = {1, 2,3};
        System.out.println(solution.findContentChildren(g, s));
    }
}