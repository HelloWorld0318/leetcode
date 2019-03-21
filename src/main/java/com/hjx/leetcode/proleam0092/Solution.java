package com.hjx.leetcode.proleam0092;

import com.hjx.leetcode.entity.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n - m == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        int changeLength = n - m + 1;

        while (m-- > 1) {
            pre = pre.next;
            cur = cur.next;
            next = next.next;
        }

        while (changeLength-- > 1) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

            next = cur.next;
        }
        return dummy.next;
    }

}
