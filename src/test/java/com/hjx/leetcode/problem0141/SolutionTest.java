package com.hjx.leetcode.problem0141;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void hasCycle() {
        Solution solution = new Solution();
        ListNode headA = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        headA.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(solution.hasCycle(headA));
    }
}