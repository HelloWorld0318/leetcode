package com.hjx.leetcode.problem0114;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void flattenMethod1() {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        solution.flattenMethod1(node1);
        System.out.println();
    }

    @Test
    public void flatten() {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;
        node5.left = node7;

        TreeNode root = node1;
        solution.flatten(node1);
        System.out.println(root.val);
    }
}