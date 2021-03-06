package com.hjx.leetcode.problem0088;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (array[i] < nums2[j]) {
                nums1[k++] = array[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = array[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}
