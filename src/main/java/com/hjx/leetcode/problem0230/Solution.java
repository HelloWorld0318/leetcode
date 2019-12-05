package com.hjx.leetcode.problem0230;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {

    private int k;
    private int val;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return val;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (k > 0) {
            inOrder(root.left);
        }
        if (--k == 0) {
            val = root.val;
            return;
        }
        if (k > 0) {
            inOrder(root.right);
        }
    }

}
