package com.hjx.leetcode.problem0322;

/**
 * @author houjinxiang
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示金额为i的时候最小值
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            // 初始化数据，所有金额都无法可达
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int index = i - coins[j];
                if (index >= 0 && dp[index] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[index] + 1) {
                        dp[i] = dp[index] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}