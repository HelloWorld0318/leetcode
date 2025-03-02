package com.hjx.leetcode.problem1670;

import java.util.LinkedList;

public class FrontMiddleBackQueue {

    private LinkedList<Integer> left;
    private LinkedList<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
        rebalance();
    }

    public void pushMiddle(int val) {
        left.addLast(val);
        rebalance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }

    public int popFront() {
        if (this.size() == 0) {
            return -1;
        }
        int val = 0;
        if (!left.isEmpty()) {
            val = left.removeFirst();
        } else {
            val = right.removeFirst();
        }
        rebalance();
        return val;
    }

    public int popMiddle() {
        if (size() == 0) {
            return -1;
        }
        int val =0;
        if (left.size() == right.size()) {
            val = left.removeLast();
        } else {
            val = right.removeFirst();
        }
        rebalance();
        return val;
    }

    public int popBack() {
        if (size() == 0) {
            return -1;
        }
        int val = right.removeLast();
        rebalance();
        return val;
    }

    private void rebalance() {
        if (right.size() > left.size() + 1) {
            left.addLast(right.removeFirst());
        } else if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
    }

    private int size() {
        return left.size() + right.size();
    }
}