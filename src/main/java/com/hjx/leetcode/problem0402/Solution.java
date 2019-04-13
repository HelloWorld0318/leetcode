package com.hjx.leetcode.problem0402;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] array = num.toCharArray();
        for (int i = 0; i < array.length; i++) {
            // greedy method
            while (!stack.isEmpty() && stack.peek() > array[i] && k-- > 0) {
                stack.pop();
            }
            // 去除前导0
            if (array[i] != '0' || !stack.isEmpty()) {
                stack.push(array[i]);
            }
        }
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.reverse().toString();
    }
}
