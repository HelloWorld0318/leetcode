package com.hjx.leetcode.problem0718;

import java.util.Arrays;

public class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        //          | 0, i=0 or j=0
        // c[i][j] =| c[i-1][j-1], if nums1[i-1] == nums2[j-1]
        //          | 0,if nums1[i-1] != nums2[j-1]
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        int max = 0;
        int maxi = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                    maxi = i;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int[] duplicateSubArray = new int[max];
        int index = 0;
        for (int i = maxi - max; i < maxi; i++) {
            duplicateSubArray[index++] = nums1[i];
        }
        System.out.println(Arrays.toString(duplicateSubArray));
        return max;
    }

}
