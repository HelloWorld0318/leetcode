package com.hjx.leetcode.problem0042;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = 0;
        right[height.length - 1] = 0;

        int leftHeight = height[0];
        int rightHeight = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            left[i] = leftHeight;
            if (leftHeight < height[i]) {
                leftHeight = height[i];
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = rightHeight;
            if (rightHeight < height[i]) {
                rightHeight = height[i];
            }
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int low = Math.min(left[i], right[i]);
            if (height[i] < low) {
                ans += low - height[i];
            }
        }
        return ans;
    }
}