package com.hjx.leetcode.problem0046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(1 << nums.length + 1);
        if (nums.length != 0) {
            dfs(nums, 0, ans);
        }
        return ans;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> oneResult = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]);
            }
            ans.add(oneResult);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
