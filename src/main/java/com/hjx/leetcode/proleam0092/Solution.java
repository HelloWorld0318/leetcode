package com.hjx.leetcode.proleam0092;

import com.hjx.leetcode.entity.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        dummy.next = head;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;

            cur = pre.next;
        }
        return dummy.next;
    }

}
