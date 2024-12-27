package com.hjx.leetcode.lcr140;

import com.hjx.leetcode.entity.ListNode;

class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node1 = dummy, node2 = dummy;
        while (cnt-- > 0) {
            node1 = node1.next;
        }
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }
}
