package com.hjx.leetcode.problem0109;

import com.hjx.leetcode.entity.ListNode;
import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sortedListToBST() {
        ListNode listNode10 = new ListNode(-10);
        ListNode listNode3 = new ListNode(-3);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode9 = new ListNode(9);

        listNode10.next = listNode3;
        listNode3.next = listNode0;
        listNode0.next = listNode5;
        listNode5.next = listNode9;

        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedListToBST(listNode10);
        inOrder(treeNode);
    }

    private void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.left);
        inOrder(treeNode.right);
    }
}