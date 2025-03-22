package com.hjx.leetcode.problem1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        //         | 0, 若i=0 或者 j=0
        //c[i][j]  | c[i-1][j-1] 若i,j >0 且 text1[i] =  text2[j]
        //         | max(c[i-1][j],c[i][j-1]) 若i,j >0且 text1[i] != text2[j]
        int m = text1.length();
        int n = text2.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            result[m][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            result[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = m; i >= 1; ) {
            for (int j = n; j >= 1 && i >= 1; ) {
                if (result[i][j] == result[i - 1][j - 1] + 1 && text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    stringBuilder.insert(0, text2.charAt(j - 1));
                    i--;
                    j--;
                } else if (result[i][j] == result[i - 1][j]) {
                    i = i - 1;
                } else if (result[i][j] == result[i][j - 1]) {
                    j = j - 1;
                }
            }
            //stringBuilder记录最长的公共子序列的值
            System.out.println(stringBuilder);
        }
        return result[m][n];
    }
}
