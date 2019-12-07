package com.hjx.leetcode.problem0137;

public class Solution {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += (nums[i] >>> j) & 1;
                bits[j] %= 3;
            }
        }

        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            ans += bits[i] << i;
        }
        return ans;
    }
}
