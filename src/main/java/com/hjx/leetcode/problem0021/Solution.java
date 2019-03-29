package com.hjx.leetcode.problem0021;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l2.val <= l1.val)) {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
        }
        return dummy.next;
    }
}
