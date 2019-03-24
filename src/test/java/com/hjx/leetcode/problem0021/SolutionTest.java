package com.hjx.leetcode.problem0021;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void mergeTwoLists() {
        Solution solution = new Solution();
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(4);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(3);
        ListNode nodeB3 = new ListNode(4);
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        ListNode result = solution.mergeTwoLists(nodeA1, nodeB1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}