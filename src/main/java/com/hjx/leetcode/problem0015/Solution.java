package com.hjx.leetcode.problem0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int target = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    ans.add(result);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int val = nums[i];
            List<List<Integer>> twoSumResult = twoSum(nums, i + 1, nums.length - 1, target - val);
            if (!twoSumResult.isEmpty()) {
                for (List<Integer> integers : twoSumResult) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(val);
                    oneResult.addAll(integers);
                    res.add(oneResult);
                }
            }
            while (i < nums.length && nums[i] == val) {
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            int leftVal = nums[start], rightVal = nums[end];
            if (sum < target) {
                while (start < end && nums[start] == leftVal) {
                    start++;
                }
            } else if (sum > target) {
                while (start < end && nums[end] == rightVal) {
                    end--;
                }
            } else {
                res.add(new ArrayList<>(Arrays.asList(leftVal, rightVal)));
                while (start < end && nums[start] == leftVal) {
                    start++;
                }
                while (start < end && nums[end] == rightVal) {
                    end--;
                }
            }
        }
        return res;
    }
}
