package com.hjx.leetcode.problem0494;

public class Solution {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, 0, target);
        return res;
    }

    public void backTrack(int[] nums, int i, int remaining) {
        if (i >= nums.length) {
            if (remaining == 0) {
                res++;
            }
            return;
        }
        int val = nums[i];
        backTrack(nums, i + 1, remaining + val);
        backTrack(nums, i + 1, remaining - val);
    }

}
