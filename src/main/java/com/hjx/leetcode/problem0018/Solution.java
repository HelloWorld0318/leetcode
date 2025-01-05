package com.hjx.leetcode.problem0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums != null && nums.length >= 4) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int left = j + 1;
                    int right = nums.length - 1;

                    while (left < right) {
                        if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                            List<Integer> oneAns = new ArrayList<>();
                            oneAns.add(nums[i]);
                            oneAns.add(nums[j]);
                            oneAns.add(nums[left]);
                            oneAns.add(nums[right]);
                            ans.add(oneAns);
                            left++;
                            right--;
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                            left++;
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                        } else {
                            right--;
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int val = nums[i];
            List<List<Integer>> threeSumResult = threeSum(nums, i + 1, nums.length - 1, target - val);
            if (!threeSumResult.isEmpty()) {
                for (List<Integer> integers : threeSumResult) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(val);
                    oneResult.addAll(integers);
                    res.add(oneResult);
                }
            }
            while (i <= nums.length - 1 && nums[i] == val) {
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int end, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = start;
        while (i <= end - 2) {
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
            while (i <= end && nums[i] == val) {
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int end, long target) {
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
