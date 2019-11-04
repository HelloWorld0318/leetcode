package com.hjx.leetcode.problem0053;

/**
 * @author houjinxiang
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] = max{dp[i-1] + nums[i],nums[i]}
        // 第i个状态(dp[i])代表以第i个数字结尾的最大子段和(最优解)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
