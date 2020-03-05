package com.hjx.leetcode.problem0141;

import com.hjx.leetcode.entity.ListNode;

public class Solution {
    /**
     * 快慢指针
     * 设置两个指针，一个快，一个慢，快的指针每次走两步，慢的指针每次走一步，
     * 如果快指针和慢指针相遇，则说明有环
     *
     * @param head 链表头节点
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
