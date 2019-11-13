package com.hjx.leetcode.problem0101;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null && left.val == right.val) {
            return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }
}
