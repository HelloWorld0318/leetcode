package com.hjx.leetcode.problem0064;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < column; i++) {
            if (i == 0) {
                dp[0][0] = grid[0][0];
            } else {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        }
        for (int j = 0; j < row; j++) {
            if (j == 0) {
                dp[0][0] = grid[0][0];
            } else {
                dp[j][0] = dp[j - 1][0] + grid[j][0];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }
}
