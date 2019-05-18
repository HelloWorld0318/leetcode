package com.hjx.leetcode.problem0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(1 << nums.length);
        if (nums.length != 0) {
            Arrays.sort(nums);
            // 广度优先遍历
            dfs(nums, 0, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> item, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(item));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            item.add(nums[i]);
            dfs(nums, i + 1, item, ans);
            item.remove(item.size() - 1);
        }
    }
}
