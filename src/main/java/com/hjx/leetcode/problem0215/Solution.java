package com.hjx.leetcode.problem0215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        int i = 0;
        while (i < k) {
            queue.offer(nums[i++]);
        }
        while (i < nums.length) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
            i++;
        }
        return queue.peek();
    }
}
