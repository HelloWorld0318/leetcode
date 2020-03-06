package com.hjx.leetcode.problem0080;

public class Solution {

    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    public int removeDuplicates(int[] nums, int canDuplicatedCount) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= canDuplicatedCount) {
            return nums.length;
        }
        int index = canDuplicatedCount;
        for (int i = canDuplicatedCount; i < nums.length; i++) {
            if (nums[index - canDuplicatedCount] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
