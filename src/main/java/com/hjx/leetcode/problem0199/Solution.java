package com.hjx.leetcode.problem0199;

import com.hjx.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelSize = 1;
        int nextLevelSize = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevelSize--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLevelSize++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelSize++;
            }
            if (curLevelSize == 0) {
                ans.add(node.val);
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }
        }
        return ans;
    }
}
