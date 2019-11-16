package com.hjx.leetcode.problem0117;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Node connect(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int curLevelNodeCount = 1, nextLevelNodeCount = 0;
            while (!queue.isEmpty()) {
                curLevelNodeCount--;
                Node node = queue.poll();
                if (curLevelNodeCount > 0) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNodeCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNodeCount++;
                }
                if (curLevelNodeCount == 0) {
                    curLevelNodeCount = nextLevelNodeCount;
                    nextLevelNodeCount = 0;
                }
            }
        }
        return root;
    }
}
