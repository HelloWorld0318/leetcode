package com.hjx.leetcode.problem0354;

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > target) {
                    right = mid;
                } else if (top[mid] == target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = target;
        }
        return piles;
    }
}
