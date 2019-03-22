package com.hjx.leetcode.problem0024;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void swapPairs() {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode result = solution.swapPairs(node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}