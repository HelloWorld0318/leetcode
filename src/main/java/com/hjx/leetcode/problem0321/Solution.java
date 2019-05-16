package com.hjx.leetcode.problem0321;

public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        // i的初始值表示nums1中的元素在ans中最少出现的个数
        for (int i = Math.max(0, k - nums2.length); i <= k && i <= nums1.length; i++) {
            int[] candidateArray = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidateArray, 0, ans, 0)) {
                ans = candidateArray;
            }
        }
        return ans;
    }

    /**
     * 从一个数组当中选取k个数字，是子数组组成的数字最大(贪心的策略)
     *
     * @param nums digits 0-9 representing numbers
     * @param k    数组中取多少个数字
     * @return nums中取k个数字形成最大值的子数组
     */
    public int[] maxArray(int[] nums, int k) {
        if (k >= nums.length) {
            return nums;
        }
        int[] result = new int[k];
        // popSize 表示应该从nums中淘汰的元素个数
        int popSize = nums.length - k;
        for (int i = 0, j = 0; i < nums.length; i++) {
            // i - k 表示当前已经淘汰掉的元素个数，已淘汰的元素一定要小于popSize
            while (popSize - (i - j) > 0 && j > 0 && nums[i] > result[j - 1]) {
                j--;
            }
            if (j < k) {
                result[j++] = nums[i];
            }
        }
        return result;
    }

    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
