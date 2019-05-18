package com.hjx.leetcode.problem0078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>((int) Math.pow(2, nums.length));
        // 将空集放入结果集当中
        ans.add(new ArrayList<>());
        if (nums.length != 0) {
            dfs(nums, 0, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> ans) {
        if (index == nums.length) {
            return;
        }
        // 放元素
        temp.add(nums[index]);
        ans.add(new ArrayList<>(temp));
        dfs(nums, index + 1, temp, ans);
        // 不放元素
        temp.remove(temp.size() - 1);
        dfs(nums, index + 1, temp, ans);
    }
}
