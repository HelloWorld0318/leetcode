package com.hjx.leetcode.problem0142;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode meetNode = fast;
                while (head != meetNode) {
                    head = head.next;
                    meetNode = meetNode.next;
                }
                return head;
            }
        }
        return null;
    }
}
