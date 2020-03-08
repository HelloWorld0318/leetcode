package com.hjx.leetcode.problem0066;

import org.junit.Test;

import java.net.Socket;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void plusOne() {
        Solution s = new Solution();
        int[] digits = {9};
        int[] ans = s.plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }
}