package com.hjx.leetcode.problem0084;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] temp = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            temp[i] = heights[i];
        }
        heights = temp;
        // 构造一个递增的栈
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, h = 0, w = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    h = heights[stack.peek()];
                    stack.pop();
                    w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
