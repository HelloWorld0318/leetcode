package com.hjx.leetcode.problem0004;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (finkKth(nums1, 0, nums2, 0, len / 2)
                    + finkKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        } else {
            return finkKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }

    public int finkKth(int[] nums1, int index1, int[] nums2, int index2, int kth) {
        if (index1 >= nums1.length) {
            return nums2[index2 + kth - 1];
        } else if (index2 >= nums2.length) {
            return nums1[index1 + kth - 1];
        }
        if (kth == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        int nums1Value = index1 + kth / 2 - 1 < nums1.length ? nums1[index1 + kth / 2 - 1] : Integer.MAX_VALUE;
        int nums2Value = index2 + kth / 2 - 1 < nums2.length ? nums2[index2 + kth / 2 - 1] : Integer.MAX_VALUE;
        if (nums1Value > nums2Value) {
            return finkKth(nums1, index1, nums2, index2 + kth / 2, kth - kth / 2);
        } else {
            return finkKth(nums1, index1 + kth / 2, nums2, index2, kth - kth / 2);
        }
    }
}
