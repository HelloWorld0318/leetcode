package com.hjx.leetcode.problem0045;

import java.util.Arrays;

/**
 * @author houjinxiang
 */
public class Solution {

    private int[] memo;

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    /**
     * 从索引p跳到数组的最后一个位置需要的最小跳数
     *
     * @param nums 数组
     * @param p    索引p
     * @return 最小跳数
     */
    public int dp(int[] nums, int p) {
        if (p >= nums.length - 1) {
            return 0;
        }
        if (memo[p] != -1) {
            return memo[p];
        }
        int step = nums[p];
        int res = nums.length;
        for (int i = 1; i <= step; i++) {
            int subProblem = dp(nums, p + i);
            res = Math.min(res, subProblem + 1);
        }
        memo[p] = res;
        return res;
    }
}
