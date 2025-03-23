package com.hjx.leetcode.sort;

/**
 * @author houjinxiang
 * 快速排序
 */
public class QuickSort {

    public int partition(int[] nums, int start, int end) {
        int key = nums[end];
        int index = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < key) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, index + 1, end);
        return index + 1;
    }

    public void quickSort(int[] array) {
        if (array != null && array.length > 1) {
            quickSort(array, 0, array.length - 1);
        }
    }

    public void quickSort(int[] array, int start, int end) {
        if (end > start) {
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
