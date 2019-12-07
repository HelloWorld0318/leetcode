package com.hjx.leetcode.problem0449;

import com.hjx.leetcode.entity.TreeNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void serialize() {

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2 = new TreeNode(2);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;

        treeNode1.right = treeNode2;

        Solution solution = new Solution();
        String str = solution.serialize(treeNode3);
        System.out.println(str);
    }

    @Test
    public void deserialize() {
        Solution solution = new Solution();
        String str = "3#1#2#4";
        TreeNode treeNode = solution.deserialize(str);
        System.out.println(treeNode);
    }

}