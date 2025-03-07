package com.hjx.leetcode.problem1438;

import java.util.LinkedList;

public class Solution {

    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        MonotonicQueue<Integer> windows = new MonotonicQueue<>();
        int res = 0;
        while (right < nums.length) {
            windows.push(nums[right]);
            right++;

            while (windows.max() - windows.min() > limit && left < right) {
                windows.pop();
                left++;
            }

            res = Math.max(res, right - left);
        }
        return res;
    }

}

class MonotonicQueue<E extends Comparable<E>> {

    /**
     * 常规队列，存储所有元素
     */
    private LinkedList<E> q = new LinkedList<>();

    /**
     * 元素降序排列的单调队列，头部是最大值
     */
    private LinkedList<E> maxQ = new LinkedList<>();

    /**
     * 元素升序排列的单调队列，头部是最小值
     */
    private LinkedList<E> minQ = new LinkedList<>();

    public void push(E elem) {
        q.addLast(elem);

        // 维护 maxq，将小于 elem 的元素全部删除
        while (!maxQ.isEmpty() && maxQ.getLast().compareTo(elem) < 0) {
            maxQ.pollLast();
        }
        maxQ.addLast(elem);

        // 维护 minq，将大于 elem 的元素全部删除
        while (!minQ.isEmpty() && minQ.getLast().compareTo(elem) > 0) {
            minQ.pollLast();
        }
        minQ.addLast(elem);
    }

    public E max() {
        assert !maxQ.isEmpty();
        return maxQ.getFirst();
    }

    public E min() {
        assert !minQ.isEmpty();
        return minQ.getFirst();
    }

    public E pop() {
        E delElem = q.pollFirst();
        assert delElem != null;

        if (!maxQ.isEmpty() && delElem.equals(maxQ.getFirst())) {
            maxQ.pollFirst();
        }

        if (!minQ.isEmpty() && delElem.equals(minQ.getFirst())) {
            minQ.pollFirst();
        }

        return delElem;
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}