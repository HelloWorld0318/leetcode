package com.hjx.leetcode.sort;

public class HeapSort {

    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int heapSize = nums.length;

        while (heapSize > 1) {
            nums[0] = (nums[0] + nums[heapSize - 1]) - (nums[heapSize - 1] = nums[0]);
            modifyMaxHeap(nums, 0, --heapSize);
        }
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            modifyMaxHeap(nums, i, nums.length);
        }
    }

    public void modifyMaxHeap(int[] nums, int index, int heapSize) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = (index << 1) + 2;

        int maxValueIndex = index;
        if (leftIndex < heapSize && nums[leftIndex] > nums[maxValueIndex]) {
            maxValueIndex = leftIndex;
        }
        if (rightIndex < heapSize && nums[rightIndex] > nums[maxValueIndex]) {
            maxValueIndex = rightIndex;
        }
        if (maxValueIndex != index) {
            nums[maxValueIndex] = (nums[maxValueIndex] + nums[index]) - (nums[index] = nums[maxValueIndex]);
            modifyMaxHeap(nums, maxValueIndex, heapSize);
        }
    }
}
