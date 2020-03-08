package com.hjx.leetcode.problem0047;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            dfs(nums, 0, ans);
        }
        return ans;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> oneAns = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                oneAns.add(nums[i]);
            }
            ans.add(oneAns);
        }

        for (int i = index; i < nums.length; i++) {
            if (seen(nums, index, i)) {
                continue;
            }
            swap(nums, index, i);
            dfs(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
    }

    public boolean seen(int[] nums, int start, int end) {
        if (end > start) {
            for (int i = start; i < end; i++) {
                if (nums[i] == nums[end]) {
                    return true;
                }
            }
        }
        return false;
    }
}
