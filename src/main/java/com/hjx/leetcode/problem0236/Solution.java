package com.hjx.leetcode.problem0236;

import com.hjx.leetcode.entity.TreeNode;

import java.util.Stack;

public class Solution {

    public static boolean isEnd;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        if (root != null) {
            TreeNode temp = root;
            Stack<TreeNode> path = new Stack<>();
            Stack<TreeNode> pathP = new Stack<>();
            Stack<TreeNode> pathQ = new Stack<>();

            isEnd = false;
            preOrder(root, p, path, pathP);

            isEnd = false;
            path.clear();
            preOrder(temp, q, path, pathQ);

            int minPath = Math.min(pathP.size(), pathQ.size());
            for (int i = 0; i < minPath; i++) {
                if (pathP.get(i) == pathQ.get(i)) {
                    result = pathP.get(i);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public void preOrder(TreeNode root, TreeNode findNode, Stack<TreeNode> path, Stack<TreeNode> result) {
        if (root == null || isEnd) {
            return;
        }
        path.push(root);
        if (root == findNode) {
            isEnd = true;
            result.addAll(path);
            return;
        }
        preOrder(root.left, findNode, path, result);
        preOrder(root.right, findNode, path, result);
        path.pop();
    }
}
