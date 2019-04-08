package com.hjx.leetcode.problem0295;

import org.junit.Test;

public class MedianFinderTest {

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}