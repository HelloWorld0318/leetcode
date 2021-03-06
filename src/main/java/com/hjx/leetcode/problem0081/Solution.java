package com.hjx.leetcode.problem0081;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1, medium = -1;
        while (start <= end) {
            medium = (start + end) >> 1;
            if (nums[medium] == target) {
                return true;
            }
            if (nums[start] < nums[medium]) {
                if (nums[start] <= target && target < nums[medium]) {
                    end = medium - 1;
                } else {
                    start = medium + 1;
                }
            } else if (nums[start] > nums[medium]) {
                if (nums[medium] < target && target <= nums[end]) {
                    start = medium + 1;
                } else {
                    end = medium - 1;
                }
            } else {
                start++;
            }
        }
        return false;
    }
}
