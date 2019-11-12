package com.hjx.leetcode.problem0114;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {

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
        // TODO hjx
    }
}
