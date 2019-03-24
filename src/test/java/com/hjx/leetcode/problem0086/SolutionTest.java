package com.hjx.leetcode.problem0086;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void partition() {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution solution = new Solution();

        ListNode result = solution.partition(head1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}