package com.hjx.leetcode.problem0224;

import java.util.Stack;

public class Solution {
    public int calculate(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (array[i] >= '0') {
                int num = 0;
                while (i < length && array[i] >= '0') {
                    num = num * 10 + array[i++] - '0';
                }
                result += sign * num;
                // 注意这里进行i--
                i--;
            } else if (array[i] == '+') {
                sign = 1;
            } else if (array[i] == '-') {
                sign = -1;
            } else if (array[i] == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (array[i] == ')') {
                result *= stack.pop();
                result += stack.pop();
            }
        }
        return result;
    }
}
