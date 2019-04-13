package com.hjx.leetcode.problem0502;

import java.util.PriorityQueue;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (capital[a] - capital[b]));
        for (int i = 0; i < capital.length; i++) {
            minHeap.offer(i);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        while (k-- > 0) {
            while (minHeap.size() > 0 && capital[minHeap.peek()] <= w) {
                maxHeap.offer(profits[minHeap.poll()]);
            }
            if (maxHeap.size() > 0) {
                w += maxHeap.poll();
            } else {
                return w;
            }
        }
        return w;
    }
}
