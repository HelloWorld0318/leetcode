package com.hjx.leetcode.problem0002;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {
        Solution solution = new Solution();
        ListNode nodeA1 = new ListNode(2);
        ListNode nodeA2 = new ListNode(4);
        ListNode nodeA3 = new ListNode(3);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(6);
        ListNode nodeB3 = new ListNode(4);
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        ListNode node = solution.addTwoNumbers(nodeA1, nodeB1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}