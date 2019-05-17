package com.hjx.leetcode.problem0001;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return nums;
        }

        int mapSize = nums.length;
        Map<Integer, Integer> value2Index = new HashMap((int) (mapSize / 0.75 + 1));

        for (int i = 0; i < nums.length; i++) {
            if (value2Index.containsKey(nums[i])) {
                return new int[]{value2Index.get(nums[i]), i};
            }
            value2Index.put(target - nums[i], i);
        }
        return null;
    }

}
