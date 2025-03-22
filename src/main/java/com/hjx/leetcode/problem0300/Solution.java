package com.hjx.leetcode.problem0300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 动态规划 dp[i]表示已nums[i]结尾的最长递增子序列的长度
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxLength = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = dp[i] > maxLength ? dp[i] : maxLength;
        }
        return maxLength;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int porker = nums[i];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > porker) {
                    right = mid;
                } else if (top[mid] == porker) {
                    right = mid;
                } else if (top[mid] < porker) {
                    left = mid + 1;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = porker;
        }
        //top数组从0到piles就是最大递增子序列
        return piles;
    }
}
