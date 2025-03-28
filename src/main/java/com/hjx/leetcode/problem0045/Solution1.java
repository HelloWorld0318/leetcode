package com.hjx.leetcode.problem0045;

public class Solution1 {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int step = 0;
        //[left,right]表示当前能覆盖的区间
        int left = 0;
        int right = 0;

        while (left <= right) {
            step++;
            int newRight = 0;
            for (int i = left; i <= right; i++) {
                newRight = Math.max(newRight, nums[i] + i);
                if (newRight >= nums.length - 1) {
                    return step;
                }
            }
            //新的左区间值
            left = right + 1;
            if (right < newRight) {
                right = newRight;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        int res = s.jump(nums);
        System.out.println(res);
    }
}
