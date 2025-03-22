package com.hjx.leetcode.problem1143;


import org.junit.Test;

public class SolutionTest {

    @Test
    public void testLongestCommonSubsequence() {
//        输入：text1 = "abcde", text2 = "ace" 输出：3 解释：最长公共子序列是 "ace" ，它的长度为 3 。
        String text1 = "bl";
        String text2 = "ybly";
        Solution solution = new Solution();
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }
}