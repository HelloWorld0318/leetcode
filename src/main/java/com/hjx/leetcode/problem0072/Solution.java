package com.hjx.leetcode.problem0072;

public class Solution {

    /**
     * 递归解法容易超时，存在重复求解子问题的情况
     *
     * @param word1 第一个字符串
     * @param word2 第二个字符串
     * @return word1变成word2的最小步数
     */
    public int minDistanceRecursion(String word1, String word2) {
        // Time Limit Exceeded
        // method 1:递归
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        if (word1.equals(word2)) {
            return 0;
        }
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            return minDistanceRecursion(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        } else {
            int min1 = minDistanceRecursion(word1.substring(0, word1.length() - 1), word2);
            int min2 = minDistanceRecursion(word1, word2.substring(0, word2.length() - 1));
            int min3 = minDistanceRecursion(word1.substring(0, word1.length() - 1),
                    word2.substring(0, word2.length() - 1));
            return Math.min(min1, Math.min(min2, min3)) + 1;
        }
    }

    public int minDistance(String word1, String word2) {
        // 动态规划
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0 || length2 == 0) {
            return Math.max(length1, length2);
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= length2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                int d = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d = 0;
                }
                int min1 = dp[i - 1][j] + 1;
                int min2 = dp[i][j - 1] + 1;
                int min3 = dp[i - 1][j - 1] + d;
                dp[i][j] = Math.min(min1, Math.min(min2, min3));
            }
        }
        return dp[length1][length2];
    }
}
