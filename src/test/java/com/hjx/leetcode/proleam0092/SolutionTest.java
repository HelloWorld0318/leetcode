package com.hjx.leetcode.proleam0092;

import com.hjx.leetcode.entity.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        ListNode result = solution.reverseList(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}