package com.hjx.leetcode.problem0138;

import com.hjx.leetcode.entity.Node;

public class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val, null, null);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        Node dummy = new Node(-1, null, null);
        cur = head;
        Node newLinkListCur = dummy;
        while (cur != null) {
            newLinkListCur.next = cur.next;
            newLinkListCur = newLinkListCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}