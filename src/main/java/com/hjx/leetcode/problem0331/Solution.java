package com.hjx.leetcode.problem0331;

import java.util.Stack;

public class Solution {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        String[] arr = preorder.split(",");
        String nullFlag = "#";
        if (arr.length > 1 && arr[0].equals(nullFlag)) {
            return false;
        }
        if (arr.length == 1 && arr[0].equals(nullFlag)) {
            return true;
        }

        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            String s = arr[i];
            if (!s.equals(nullFlag)) {
                stack.push(s);
                i++;
            } else {
                if (!stack.isEmpty() && nullFlag.equals(stack.peek())) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(s);
                    i++;
                }
            }
        }
        return stack.size() == 1 && stack.peek().equals(nullFlag);
    }

}
