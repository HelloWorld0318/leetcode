package com.hjx.leetcode.problem0295;

import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.peek() != null && maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize != minHeapSize && maxHeapSize - 1 != minHeapSize) {
            if (maxHeapSize < minHeapSize) {
                maxHeap.offer(minHeap.poll());
            } else {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
