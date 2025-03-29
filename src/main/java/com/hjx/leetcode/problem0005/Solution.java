package com.hjx.leetcode.problem0005;

public class Solution {

    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            if (s1.length() > res.length()) {
                res = s1;
            }
            if (s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    /**
     * 以s[left],s[right]为中心的扩展的最长的回文串，从中心进行扩展，刷题就是这样，思路从左边不行的时候，就从右面，右面不行，那就从中间进行
     *
     * @param s     字符串s
     * @param left  字符串s的left索引
     * @param right 字符串s的right索引
     * @return 最长的回文串
     */
    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
