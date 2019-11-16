package com.hjx.leetcode.problem0207;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 方法2：拓扑排序（宽度优先搜索）
        if (numCourses <= 1) {
            return true;
        }
        int[] degree = new int[numCourses];
        GraphNode[] graphNodes = new GraphNode[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graphNodes[i] = new GraphNode(i);
            degree[i] = 0;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graphNodes[start].graphNodeList.add(graphNodes[end]);
            degree[end]++;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(graphNodes[i]);
            }
        }
        while (!queue.isEmpty()) {
            GraphNode graphNode = queue.poll();
            for (int i = 0; i < graphNode.graphNodeList.size(); i++) {
                degree[graphNode.graphNodeList.get(i).lable]--;
                if (degree[graphNode.graphNodeList.get(i).lable] == 0) {
                    queue.offer(graphNode.graphNodeList.get(i));
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinishDfsMethod(int numCourses, int[][] prerequisites) {
        // 该题目可以转化为判断一个图中是否存在环
        if (numCourses <= 1) {
            return true;
        }
        GraphNode[] graphNodes = new GraphNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphNodes[i] = new GraphNode(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            // prerequisites里面的一个数组代表一条边
            // 课程1，课程2 表示课程1依赖课程2
            // 课程2
            int start = prerequisites[i][1];
            // 课程1
            int end = prerequisites[i][0];
            // 课程1添加的课程2的邻接表里面(课程2指向课程1)
            graphNodes[start].graphNodeList.add(graphNodes[end]);
        }
        // -1表示未访问过，0表示正在访问，1表示已访问过
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visit[i] = -1;
        }
        for (int i = 0; i < numCourses; i++) {
            // 如果节点没有被访问过，进行dfs，如果遇到环，返回无法完成
            if (visit[i] == -1 && !dfs(graphNodes[i], visit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 访问该节点的过程中，是否 没有遇到环 true:没有，false：遇到了环
     *
     * @param graphNode
     * @param visit
     * @return
     */
    private boolean dfs(GraphNode graphNode, int[] visit) {
        // 设置为0表示正在访问
        visit[graphNode.lable] = 0;
        // 访问该节点的邻接表
        for (int i = 0; i < graphNode.graphNodeList.size(); i++) {
            if (visit[graphNode.graphNodeList.get(i).lable] == -1) {
                if (!dfs(graphNode.graphNodeList.get(i), visit)) {
                    return false;
                }
            } else if (visit[graphNode.graphNodeList.get(i).lable] == 0) {
                return false;
            } else {
                // 已经访问过的，不在dfs搜索
            }
        }
        visit[graphNode.lable] = 1;
        return true;
    }
}
