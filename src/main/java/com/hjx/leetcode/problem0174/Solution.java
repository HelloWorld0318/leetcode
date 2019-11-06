package com.hjx.leetcode.problem0174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // dp[i][j]即代表若要达到右下角，至少有多少血量，能在行走的过程中至少保持生命值为1
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row][column];
        for (int i = row - 1; i >= 0; i--) {
            if (i == row - 1) {
                dp[i][column - 1] = Math.max(1 - dungeon[i][column - 1], 1);
            } else {
                dp[i][column - 1] = Math.max(1, dp[i + 1][column - 1] - dungeon[i][column - 1]);
            }
        }
        for (int i = column - 1; i >= 0; i--) {
            if (i == column - 1) {
                dp[row - 1][i] = Math.max(1 - dungeon[row - 1][i], 1);
            } else {
                dp[row - 1][i] = Math.max(dp[row - 1][i + 1] - dungeon[row - 1][i], 1);
            }
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
