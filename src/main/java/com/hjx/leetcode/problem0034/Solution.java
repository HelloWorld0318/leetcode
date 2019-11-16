package com.hjx.leetcode.problem0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int medium = (start + end) / 2;
                if (nums[medium] == target) {
                    // 在这里搞事情
                    start = medium;
                    end = medium;
                    while (start >= 0 && nums[start] == target) {
                        start--;
                    }
                    while (end < nums.length && nums[end] == target) {
                        end++;
                    }
                    return new int[]{start + 1, end - 1};
                } else if (nums[medium] < target) {
                    start = medium + 1;
                } else {
                    end = medium - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
