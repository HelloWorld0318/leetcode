package com.hjx.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void quickSort() {
        QuickSort quickSort = new QuickSort();
        int[] nums = {4, 1, 7, 9, 9, 0};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}