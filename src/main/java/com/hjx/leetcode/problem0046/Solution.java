package com.hjx.leetcode.problem0046;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        // 排列问题
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length != 0) {
            dfs(nums, 0, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
