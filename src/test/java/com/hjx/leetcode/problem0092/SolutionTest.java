package com.hjx.leetcode.problem0092;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void reverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode head = solution.reverseBetween(node1, 2, 4);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}