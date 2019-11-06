package com.hjx.leetcode.problem0063;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            if (obstacleGrid[0][0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        for (int j = column - 1; j >= 0; j--) {
            if (obstacleGrid[row - 1][j] == 1) {
                for (int k = j; k >= 0; k--) {
                    dp[row - 1][k] = -1;
                }
                break;
            } else {
                dp[row - 1][j] = 1;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (obstacleGrid[i][column - 1] == 1) {
                for (int k = i; k >= 0; k--) {
                    dp[k][column - 1] = -1;
                }
                break;
            } else {
                dp[i][column - 1] = 1;
            }
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    if (dp[i + 1][j] == -1 && dp[i][j + 1] == -1) {
                        dp[i][j] = -1;
                    } else if (dp[i + 1][j] == -1 || dp[i][j + 1] == -1) {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                    }
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        if (dp[0][0] == -1) {
            return 0;
        }
        return dp[0][0];
    }
}