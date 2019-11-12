package com.hjx.leetcode.problem0114;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {

    /**
     * 迭代的解法
     *
     * @param root
     */
    public void flattenMethod1(TreeNode root) {
        while (root != null) {
            TreeNode node = root.left;
            if (node != null) {
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root);
    }

    /**
     * @param root
     * @return 返回当前二叉树前序遍历的最后一个节点
     */
    private TreeNode find(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode last = null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return root;
        }
        if (left != null) {
            root.left = null;
            root.right = left;
            last = find(left);
            last.right = right;
        }
        if (right != null) {
            last = find(right);
        }
        return last;
    }

}
