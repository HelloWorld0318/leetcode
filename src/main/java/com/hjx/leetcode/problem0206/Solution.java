package com.hjx.leetcode.problem0206;

import com.hjx.leetcode.entity.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;

            head = next;
        }
        return newHead;
    }

}
