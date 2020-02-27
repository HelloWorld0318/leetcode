package com.hjx.leetcode.problem0307;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumArrayTest {

    @Test
    public void sumRange() {
        int[] array = {1, 3, 5};
        NumArray numArray = new NumArray(array);
        numArray.buildSegmentTree(0, 0, array.length - 1);
//        numArray.printSegmentTree(0, 0, array.length - 1, 0);

        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}