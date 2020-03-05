package com.hjx.leetcode.problem0092;

import com.hjx.leetcode.entity.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        int changeLen = n - m + 1;
        ListNode preHead = null;
        ListNode result = head;

        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }

        ListNode mofifyListTail = head;
        ListNode newHead = null;

        while (head != null && changeLen > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;

            head = next;
            changeLen--;
        }

        mofifyListTail.next = head;

        if (preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }

        return result;
    }

}
