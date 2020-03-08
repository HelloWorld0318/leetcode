package com.hjx.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void heapSort() {
        HeapSort heapSort = new HeapSort();
        int[] nums = {4, 1, 7, 9, 9, 0, -3};
        heapSort.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}