package com.hjx.leetcode.problem0468;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void validIPAddress() {
        Solution solution = new Solution();
        String ip = "172.16.254.1";
        String ans = solution.validIPAddress(ip);
        System.out.println(ans);
    }
}