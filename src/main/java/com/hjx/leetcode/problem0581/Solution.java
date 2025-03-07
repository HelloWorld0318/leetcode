package com.hjx.leetcode.problem0581;

import java.util.Stack;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(j);
        }

        if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
            return 0;
        }
        return right - left + 1;
    }

}
