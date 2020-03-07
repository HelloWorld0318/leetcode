package com.hjx.leetcode.problem0031;

public class Solution {

    /**
     * 下一个置换
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums != null && nums.length > 1) {
            int i = nums.length - 1;
            while (i > 0 && nums[i] <= nums[i - 1]) {
                i--;
            }
            i--;
            if (i != -1) {
                int j = nums.length - 1;
                while (j > i && nums[j] <= nums[i]) {
                    j--;
                }
                nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
            }
            reverser(nums, i + 1, nums.length - 1);
        }
    }

    public void reverser(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            array[i] = (array[i] + array[j]) - (array[j] = array[i]);
        }
    }

}
