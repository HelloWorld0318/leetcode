package com.hjx.leetcode.problem0067;

public class Solution {
    public String addBinary(String strA, String strB) {
        int carry = 0;
        int i = strA.length() - 1;
        int j = strB.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(Math.max(j, i) + 1);
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = i >= 0 ? strA.charAt(i) - '0' : 0;
            int b = j >= 0 ? strB.charAt(j) - '0' : 0;
            int sum = a ^ b ^ carry;
            carry = (a & b) + (carry & (a ^ b));
            stringBuilder.append(sum);
            i--;
            j--;
        }
        return stringBuilder.reverse().toString();
    }
}
