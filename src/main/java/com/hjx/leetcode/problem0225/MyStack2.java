package com.hjx.leetcode.problem0225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {


    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int ans = queue1.poll();
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return ans;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ans = pop();
        queue1.offer(ans);
        return ans;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
