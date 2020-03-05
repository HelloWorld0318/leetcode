package com.hjx.leetcode.problem0023;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoList(left, right);
    }

    public ListNode mergeTwoList(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        while (headA != null || headB != null) {
            if (headA == null || (headB != null && headB.val < headA.val)) {
                node.next = headB;
                headB = headB.next;
            } else {
                node.next = headA;
                headA = headA.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}
