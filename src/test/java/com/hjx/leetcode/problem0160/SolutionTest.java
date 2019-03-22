package com.hjx.leetcode.problem0160;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getIntersectionNode() {
        Solution solution = new Solution();
        ListNode headA = new ListNode(0);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);

        ListNode commonNode1 = new ListNode(2);
        ListNode commonNode2 = new ListNode(4);
        commonNode1.next = commonNode2;

        headA.next = node2;
        node2.next = node3;
        node3.next = commonNode1;

        ListNode headB = new ListNode(3);
        headB.next = commonNode1;

        ListNode node = solution.getIntersectionNode(headA, headB);

        System.out.println(node);

    }
}