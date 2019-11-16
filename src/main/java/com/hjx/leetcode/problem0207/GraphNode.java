package com.hjx.leetcode.problem0207;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int lable;
    public List<GraphNode> graphNodeList;

    public GraphNode(int lable) {
        this.lable = lable;
        graphNodeList = new ArrayList<>();
    }
}
