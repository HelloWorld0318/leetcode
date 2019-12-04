package com.hjx.leetcode.problem0109;

import com.hjx.leetcode.entity.ListNode;
import com.hjx.leetcode.entity.TreeNode;

class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, getLinkListSize(head));
    }

    private TreeNode sortedListToBST(ListNode head, int len) {
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(head.val);
        }
        TreeNode root = new TreeNode(getNthNode(head, (len >> 1) + 1).val);
        root.left = sortedListToBST(head, len >> 1);
        root.right = sortedListToBST(getNthNode(head, (len >> 1) + 2), (len - 1) >> 1);
        return root;
    }

    public int getLinkListSize(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    /**
     * 获取链表第n个节点(从1开始)
     *
     * @param head 头节点
     * @param nth  第几个节点
     * @return
     */
    public ListNode getNthNode(ListNode head, int nth) {
        ListNode cur = head;
        while (--nth > 0) {
            cur = cur.next;
        }
        return cur;
    }
}

