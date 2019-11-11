package com.hjx.leetcode.problem0236;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;


public class SolutionTest {

    @Test
    public void lowestCommonAncestor() {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);


        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        node4.left = node7;
        node4.right = node8;

        TreeNode node = solution.lowestCommonAncestor(root, node3, node8);
        Assert.assertEquals(node, root);
    }

    @Test
    public void preOrder() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);


        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        node4.left = node7;
        node4.right = node8;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        solution.preOrder(root, node8, stack, result);
        System.out.println(stack.toString());
    }
}