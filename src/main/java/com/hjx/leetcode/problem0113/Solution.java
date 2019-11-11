package com.hjx.leetcode.problem0113;

import com.hjx.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        // 用栈结构去记录走过的路径
        Stack<Integer> stack = new Stack<>();
        if (root != null) {
            preOrder(root, sum, result, 0, stack);
        }
        return result;
    }

    private void preOrder(TreeNode root, int sum, List<List<Integer>> result, int pathValue, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        pathValue += root.val;
        stack.push(root.val);
        if (pathValue == sum && root.right == null && root.left == null) {
            List<Integer> list = new ArrayList<>();
            stack.forEach(item -> list.add(item));
            result.add(list);
        }
        preOrder(root.left, sum, result, pathValue, stack);
        preOrder(root.right, sum, result, pathValue, stack);
        stack.pop();
    }
}


