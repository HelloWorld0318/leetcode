package com.hjx.leetcode.problem0023;

import com.hjx.leetcode.entity.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode node1 = mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2));
        ListNode node2 = mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length));

        return mergeList(node1, node2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l2.val < l1.val)) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
