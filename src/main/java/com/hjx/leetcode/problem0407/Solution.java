package com.hjx.leetcode.problem0407;

import java.util.PriorityQueue;

public class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int trapRainWater(int[][] heightMap) {
        // 带优先级的广度优先搜索
        int ans = 0;
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return ans;
        }
        int row = heightMap.length;
        int column = heightMap[0].length;
        PriorityQueue<QueueItem> priorityQueue = new PriorityQueue<>((QueueItem o1, QueueItem o2) -> o1.height - o2.height);
        boolean[][] hasVisited = new boolean[row][column];

        for (int j = 0; j < column; j++) {
            priorityQueue.add(new QueueItem(0, j, heightMap[0][j]));
            hasVisited[0][j] = true;

            priorityQueue.add(new QueueItem(row - 1, j, heightMap[row - 1][j]));
            hasVisited[row - 1][j] = true;
        }

        for (int i = 1; i < row - 1; i++) {
            priorityQueue.add(new QueueItem(i, 0, heightMap[i][0]));
            hasVisited[i][0] = true;

            priorityQueue.add(new QueueItem(i, column - 1, heightMap[i][column - 1]));
            hasVisited[i][column - 1] = true;
        }

        while (!priorityQueue.isEmpty()) {
            QueueItem item = priorityQueue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = item.row + dx[i];
                int newY = item.column + dy[i];

                // 当扩展到的点超出范围或者已经加入到队列中
                if (newX < 0 || newX >= row || newY < 0 || newY >= column || hasVisited[newX][newY]) {
                    continue;
                }

                if (heightMap[newX][newY] < item.height) {
                    ans += item.height - heightMap[newX][newY];
                    heightMap[newX][newY] = item.height;
                }
                priorityQueue.add(new QueueItem(newX, newY, heightMap[newX][newY]));
                hasVisited[newX][newY] = true;
            }
        }
        return ans;
    }

    class QueueItem {

        /**
         * 行
         */
        public int row;

        /**
         * 列
         */
        public int column;

        /**
         * 高
         */
        public int height;

        public QueueItem(int row, int column, int height) {
            this.row = row;
            this.column = column;
            this.height = height;
        }
    }
}
