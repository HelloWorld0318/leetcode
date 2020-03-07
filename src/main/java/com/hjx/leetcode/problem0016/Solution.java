package com.hjx.leetcode.problem0016;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int minGap = Integer.MAX_VALUE;
        int globalResult = Integer.MAX_VALUE;

        Arrays.sort(nums);
        if (nums != null && nums.length > 2) {
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int localResult = nums[i] + nums[j] + nums[k];
                    if (Math.abs(localResult - target) < minGap) {
                        globalResult = localResult;
                        minGap = Math.abs(localResult - target);
                    }
                    if (localResult > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return globalResult;
    }
}
