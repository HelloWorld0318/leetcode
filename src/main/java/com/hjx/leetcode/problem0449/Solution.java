package com.hjx.leetcode.problem0449;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {
    /**
     * Encodes a tree to a single string.
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        preOrder(root, stringBuilder);
        if (stringBuilder.length() != 0) {
            return stringBuilder.subSequence(0, stringBuilder.length() - 1).toString();
        }
        return "";
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split("#");
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        for (int i = 1; i < array.length; i++) {
            bstInsertNode(root, Integer.valueOf(array[i]));
        }
        return root;
    }

    public void preOrder(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val).append("#");
        preOrder(root.left, stringBuilder);
        preOrder(root.right, stringBuilder);
    }

    public void bstInsertNode(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else {
                bstInsertNode(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else {
                bstInsertNode(root.right, val);
            }
        }
    }
}
