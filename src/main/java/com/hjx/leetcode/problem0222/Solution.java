package com.hjx.leetcode.problem0222;

import com.hjx.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int count = 0;

    public int countNodes(TreeNode root) {
        preOrder(root);
        return count;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        preOrder(root.left);
        preOrder(root.right);
    }

    public int countNodesTteration(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                size++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                size++;
                queue.offer(node.right);
            }
        }
        return size;
    }

    public int countNodesRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodesRecursion(root.left);
        int right = countNodesRecursion(root.right);
        return left + right + 1;
    }
}
