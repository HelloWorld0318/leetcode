package com.hjx.leetcode.problem0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> originNode2NewNode = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node newNode = new Node(node.val, new ArrayList<>());
        originNode2NewNode.put(node, newNode);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            Node copyNode = null;
            if (originNode2NewNode.containsKey(curNode)) {
                copyNode = originNode2NewNode.get(curNode);
            } else {
                copyNode = new Node(curNode.val, new ArrayList<>());
                originNode2NewNode.put(curNode, copyNode);
            }
            for (int i = 0; i < curNode.neighbors.size(); i++) {
                if (originNode2NewNode.containsKey(curNode.neighbors.get(i))) {
                    copyNode.neighbors.add(originNode2NewNode.get(curNode.neighbors.get(i)));
                } else {
                    Node temp = new Node(curNode.neighbors.get(i).val, new ArrayList<>());
                    originNode2NewNode.put(curNode.neighbors.get(i), temp);
                    copyNode.neighbors.add(temp);
                    queue.offer(curNode.neighbors.get(i));
                }
            }
        }
        return newNode;
    }


    public Node cloneGraphDfsMethod(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> originNode2NewNode = new HashMap<>();
        return dfs(node, originNode2NewNode);
    }

    public Node dfs(Node node, Map<Node, Node> originNode2NewNode) {
        if (node == null) {
            return null;
        }
        Node copyNode = null;
        if (originNode2NewNode.containsKey(node)) {
            return originNode2NewNode.get(node);
        } else {
            copyNode = new Node(node.val, new ArrayList<>());
            originNode2NewNode.put(node, copyNode);
        }

        if (node.neighbors != null) {
            for (int i = 0; i < node.neighbors.size(); i++) {
                Node node1 = dfs(node.neighbors.get(i), originNode2NewNode);
                copyNode.neighbors.add(node1);
            }
        }
        return copyNode;
    }

}
