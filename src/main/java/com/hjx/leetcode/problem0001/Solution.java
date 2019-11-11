package com.hjx.leetcode.problem0001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums != null || nums.length > 0) {
            Map<Integer, Integer> value2Index = new HashMap((int) (nums.length / 0.75));
            for (int i = 0; i < nums.length; i++) {
                if (value2Index.containsKey(target - nums[i])) {
                    return new int[]{value2Index.get(target - nums[i]), i};
                }
                value2Index.put(nums[i], i);
            }
        }
        return null;
    }
}
