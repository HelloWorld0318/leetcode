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
}
