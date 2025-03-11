package com.hjx.leetcode.problem0918;

import java.util.LinkedList;

public class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] preSum = new int[2 * nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[(i - 1) % nums.length];
        }

        int res = Integer.MIN_VALUE;
        MonotonicQueue<Integer> windows = new MonotonicQueue<>();
        windows.push(preSum[0]);
        for (int i = 1; i < preSum.length; i++) {
            res = Math.max(res, preSum[i] - windows.min());
            if (windows.size() == nums.length) {
                windows.pop();
            }
            windows.push(preSum[i]);
        }
        return res;
    }
}

class MonotonicQueue<E extends Comparable<E>> {

    /**
     * 常规队列，存储所有元素
     */
    private LinkedList<E> q;

    /**
     * 元素降序排序的单调队列，头部是最大值
     */
    private LinkedList<E> maxQ;

    /**
     * 元素生序排序的单调队列，头部是最小值
     */
    private LinkedList<E> minQ;

    public MonotonicQueue() {
        q = new LinkedList<>();
        maxQ = new LinkedList<>();
        minQ = new LinkedList<>();
    }

    public void push(E elem) {
        q.addLast(elem);
        //维护maxq，将小于elem的元素全部删除
        while (!maxQ.isEmpty() && maxQ.getLast().compareTo(elem) < 0) {
            maxQ.pollLast();
        }
        maxQ.addLast(elem);
        while (!minQ.isEmpty() && minQ.getLast().compareTo(elem) > 0) {
            minQ.pollLast();
        }
        minQ.addLast(elem);
    }

    public E max() {
        return maxQ.getFirst();
    }

    public E min() {
        return minQ.getFirst();
    }

    public E pop() {
        E elem = q.pollFirst();
        if (!maxQ.isEmpty() && maxQ.getFirst().equals(elem)) {
            maxQ.pollFirst();
        }
        if (!minQ.isEmpty() && minQ.getFirst().equals(elem)) {
            minQ.pollFirst();
        }
        return elem;
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
