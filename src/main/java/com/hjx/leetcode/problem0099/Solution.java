package com.hjx.leetcode.problem0099;

import com.hjx.leetcode.entity.TreeNode;

public class Solution {

    // a=[1,2,3,4,5,6,7]。如果我们交换两个不相邻的数字，例如2和6，原序列变成了a=[1,6,3,4,5,2,7]
    // 6>3 5>2,那么整个数组不是一个升序的数组，此时呢，要找到6和2的位置进行交换，x=6 y=3

    // a=[1,2,3,4,5,6,7]。如果我们交换两个相邻的数字，例如2和3，原序列变成了a=[1,3,2,4,5,6,7]
    // 此时只有3>2不满足升序条件，交换3和2的位置即可，x=3 y=2
    private TreeNode pre;
    private TreeNode first;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre == null) {
            pre = root;
        } else {
            if (pre.val > root.val) {
                if (first == null) {
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inOrder(root.right);
    }
}
