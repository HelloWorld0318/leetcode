package com.hjx.leetcode.problem0047;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(1 << nums.length);
        if (nums.length > 0) {
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
            // 如果num[index]到num[i-1]当中有与num[i]相等的元素,那就不要交换元素了
            if (seen(nums, index, i)) {
                continue;
            }
            swap(nums, index, i);
            dfs(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean seen(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;
    }
}
