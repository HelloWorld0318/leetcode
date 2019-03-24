package com.hjx.leetcode.problem0086;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyA = new ListNode(-1);
        ListNode curA = dummyA;
        ListNode dummyB = new ListNode(-1);
        ListNode curB = dummyB;

        while (head != null) {
            if (head.val < x) {
                curA.next = head;
                curA = curA.next;
            } else {
                curB.next = head;
                curB = curB.next;
            }
            head = head.next;
        }
        curB.next = null;
        curA.next = dummyB.next;
        return dummyA.next;
    }
}
