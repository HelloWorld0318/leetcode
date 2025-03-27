package com.hjx.leetcode.problem0787;

import java.util.*;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //用邻接表去表示图
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph[from].add(new int[]{to, price});
        }
        //k个中转节点，构成的边的个数为k+1
        //启动dijsktra算法
        //计算以src为起点在k次中转之后到达dst的最短路径
        return dijkstra(graph, src, dst, k + 1);
    }


    public int dijkstra(List<int[]>[] graph, int src, int dst, int k) {
        //图中节点的个数
        int nodeCount = graph.length;
        //从src到各个节点i的最短路径权重
        int[] costFromSrcArray = new int[nodeCount];
        //从src到各个节点的i的最小权重路径至少要经过nodeNumFromSrc[i]个节点
        int[] nodeNumFromSrcArray = new int[nodeCount];

        Arrays.fill(costFromSrcArray, Integer.MAX_VALUE);
        Arrays.fill(nodeNumFromSrcArray, 0);

        costFromSrcArray[src] = 0;
        nodeNumFromSrcArray[src] = 0;

        Queue<GraphNodeState> queue = new PriorityQueue<>(new Comparator<GraphNodeState>() {
            @Override
            public int compare(GraphNodeState o1, GraphNodeState o2) {
                return o1.costFromSrc - o2.costFromSrc;
            }
        });

        queue.add(new GraphNodeState(src, 0, 0));
        while (!queue.isEmpty()) {
            GraphNodeState curState = queue.poll();
            int curNodeId = curState.id;
            int curCostFromSrc = curState.costFromSrc;
            int curNodeNumFromSrc = curState.nodeNumFromSrc;

            if (curNodeId == dst) {
                //已经找到答案了，直接返回
                return curCostFromSrc;
            }
            if (curNodeNumFromSrc == k) {
                //到了当前节点，路径当中含有的节点个数已经等于限制的k个节点了，那么就continue，剪枝
                continue;
            }


            for (int[] neighborNode : graph[curNodeId]) {
                int nextNodeId = neighborNode[0];
                int costToNextNode = neighborNode[1] + curCostFromSrc;
                int nodeNumToNextNode = curNodeNumFromSrc + 1;

                //更新dp table
                if (costToNextNode < costFromSrcArray[nextNodeId]) {
                    costFromSrcArray[nextNodeId] = costToNextNode;
                    nodeNumFromSrcArray[nextNodeId] = nodeNumToNextNode;
                }

                // 如果中转次数更多，花费还更大，那必然不会是最短路径
                if (curCostFromSrc > costFromSrcArray[nextNodeId]
                        && curNodeNumFromSrc > nodeNumFromSrcArray[nextNodeId]) {
                    continue;
                }

                queue.offer(new GraphNodeState(nextNodeId, costToNextNode, nodeNumToNextNode));
            }
        }

        return -1;
    }

}

class GraphNodeState {
    /**
     * 图节点的id
     */
    public int id;

    /**
     * 从src节点到当前节点的最短路径权重
     */
    public int costFromSrc;

    /**
     * 从src节点到当前节点最短路径权重经过的节点数目
     */
    public int nodeNumFromSrc;

    public GraphNodeState(int id, int costFromSrc, int nodeNumFromSrc) {
        this.id = id;
        this.costFromSrc = costFromSrc;
        this.nodeNumFromSrc = nodeNumFromSrc;
    }
}
