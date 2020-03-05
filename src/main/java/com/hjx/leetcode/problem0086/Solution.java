package com.hjx.leetcode.problem0086;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lessNode = new ListNode(-1);
        ListNode lessPtr = lessNode;
        ListNode moreNode = new ListNode(-1);
        ListNode morePtr = moreNode;

        while (head != null) {
            if (head.val < x) {
                lessPtr.next = head;
                lessPtr = lessPtr.next;
            } else {
                morePtr.next = head;
                morePtr = morePtr.next;
            }
            head = head.next;
        }

        morePtr.next = null;
        lessPtr.next = moreNode.next;
        return lessNode.next;
    }
}
