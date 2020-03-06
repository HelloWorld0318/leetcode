package com.hjx.leetcode.problem0082;

import com.hjx.leetcode.entity.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        if (node.val == head.val) {
            while (node != null && head.val == node.val) {
                node = node.next;
            }
            return deleteDuplicates(node);
        } else {
            head.next = deleteDuplicates(node);
            return head;
        }
    }
}
