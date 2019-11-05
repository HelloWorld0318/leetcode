package com.hjx.leetcode.problem0120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 动态规划,状态转移方程为dp[i][j] = min{dp[i+1][j],dp[i+1][j+1]} + triangle[i][j]
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        Integer[] dp = triangle.get(row - 1).toArray(new Integer[0]);
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j + 1 < triangle.get(i + 1).size()) {
                    dp[j] = Math.min(dp[j + 1], dp[j]);
                }
                dp[j] += triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
