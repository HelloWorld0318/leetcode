package com.hjx.leetcode.problem0035;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int medium = (start + end) >> 1;
            if (nums[medium] == target) {
                return medium;
            } else if (nums[medium] < target) {
                start = medium + 1;
            } else {
                end = medium - 1;
            }
        }
        return start;
    }
}
