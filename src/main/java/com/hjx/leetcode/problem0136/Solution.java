package com.hjx.leetcode.problem0136;

public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        // 一个数，自己已自己进行亦或是0
        // 一个数与0进行亦或，还是他自己
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
