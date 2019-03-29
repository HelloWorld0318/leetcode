package com.hjx.leetcode.problem0023;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;


public class SolutionTest {

    @Test
    public void mergeKLists() {
        ListNode[] lists = new ListNode[3];

        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(4);
        ListNode nodeA3 = new ListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(3);
        ListNode nodeB3 = new ListNode(4);
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;

        ListNode nodeC1 = new ListNode(2);
        ListNode nodeC2 = new ListNode(6);
        nodeC1.next = nodeC2;

        lists[0] = nodeA1;
        lists[1] = nodeB1;
        lists[2] = nodeC1;

        Solution solution = new Solution();

        ListNode result = solution.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}