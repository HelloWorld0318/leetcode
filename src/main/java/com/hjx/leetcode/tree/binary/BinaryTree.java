package com.hjx.leetcode.tree.binary;

import com.hjx.leetcode.entity.TreeNode;

import java.util.Stack;

public class BinaryTree {


    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    public static void main(String[] args) {
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

        node5.left = node6;
        node5.right = node7;

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.preOrder(node1);
    }
}
