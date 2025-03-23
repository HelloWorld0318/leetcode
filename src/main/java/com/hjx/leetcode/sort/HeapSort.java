package com.hjx.leetcode.sort;

public class HeapSort {

    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int heapSize = nums.length;

        while (heapSize > 1) {
            swap(nums, 0, heapSize - 1);
            heapSize--;
            modifyMaxHeap(nums, 0, heapSize);
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
            swap(nums, maxValueIndex, index);
            modifyMaxHeap(nums, maxValueIndex, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
