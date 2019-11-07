package com.hjx.leetcode.problem0084;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0, h = 0, w = 0, n = heights.length;
        // 构造一个递增栈
        Stack<Integer> stack = new Stack<>();
        int curIndex = 0;
        while (curIndex < n) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[curIndex]) {
                h = heights[stack.pop()];
                w = stack.isEmpty() ? curIndex : curIndex - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(curIndex++);
        }
        while (!stack.isEmpty()) {
            h = heights[stack.pop()];
            w = stack.isEmpty() ? curIndex : curIndex - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}
