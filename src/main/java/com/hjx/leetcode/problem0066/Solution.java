package com.hjx.leetcode.problem0066;

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = (digits[i] + carry) % 10;
            carry = digits[i] + carry >= 10 ? 1 : 0;
            digits[i] = value;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 0) {
            return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = carry;
        for (int i = 0; i < digits.length; i++) {
            ans[i + 1] = digits[i];
        }
        return ans;
    }
}
