package com.hjx.leetcode.problem0024;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode point1 = pre.next;
        ListNode point2 = point1.next;

        while (point2 != null) {
            point1.next = point2.next;
            point2.next = pre.next;
            pre.next = point2;

            pre = point1;
            point1 = point1.next == null ? null : point1.next;
            point2 = point1 == null ? null : point1.next;
        }
        return dummy.next;
    }
}
