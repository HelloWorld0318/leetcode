package com.hjx.leetcode.problem0070;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int distinctWay1 = 1, distinctWay2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = distinctWay2;
            distinctWay2 = distinctWay1 + distinctWay2;
            distinctWay1 = temp;
        }
        return distinctWay2;
    }
}
