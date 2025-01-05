package com.hjx.leetcode.problem0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houjinxiang
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> value2Index = new HashMap((int) (nums.length / 0.75) + 1);
        for (int i = 0; i < nums.length; i++) {
            if (value2Index.containsKey(target - nums[i])) {
                return new int[]{value2Index.get(target - nums[i]), i};
            }
            value2Index.put(nums[i], i);
        }
        return null;
    }

    public List<List<Integer>> twoSumTarget(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int leftVal = nums[left], rightVal = nums[right];
            if (sum < target) {
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightVal) {
                    right--;
                }
            } else {
                res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
                while (left < right && nums[right] == rightVal) {
                    right--;
                }
            }
        }
        return res;
    }
}
