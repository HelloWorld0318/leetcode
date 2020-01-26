package com.hjx.leetcode.problem0126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 需要进一步理解
        Map<String, List<String>> graph = new HashMap<>();
        constructGraph(beginWord, wordList, graph);
        List<List<String>> ans = new ArrayList<>();
        List<QueueItem> queue = new ArrayList<>();
        List<Integer> endWordPos = new ArrayList<>();
        bfsGraph(beginWord, endWord, graph, queue, endWordPos);

        for (int i = 0; i < endWordPos.size(); i++) {
            int pos = endWordPos.get(i);
            List<String> path = new ArrayList<>();
            while (pos != -1) {
                path.add(queue.get(pos).node);
                pos = queue.get(pos).parentPos;
            }
            Collections.reverse(path);
            ans.add(path);
        }
        return ans;
    }

    /**
     * @param beginWord  开始单词
     * @param endWord    结束单词
     * @param graph      单词构成的图
     * @param queue      使用List实现的队列，可保存所有信息
     * @param endWordPos 终点endWord所在队列的位置下标
     */
    private void bfsGraph(String beginWord, String endWord, Map<String, List<String>> graph,
                          List<QueueItem> queue, List<Integer> endWordPos) {
        // <单词,步数>
        Map<String, Integer> visit = new HashMap<>();
        // 到达endWord的最小步数
        int minStep = 0;
        // 起始单词的前驱为-1
        queue.add(new QueueItem(beginWord, -1, 1));
        // 标记起始单词的步数为1
        visit.put(beginWord, 1);
        // 队列头指针front，指向vector表示的队列头
        int front = 0;
        // front指向Q.size即vector尾部时，队列为空
        while (front != queue.size()) {
            // 取队头与元素
            String node = queue.get(front).node;
            int step = queue.get(front).step;
            if (minStep != 0 && step > minStep) {
                // step>minStep时，代表所有终点的路径都搜索完成
                break;
            }
            if (node.equals(endWord)) {
                // 当搜索到结果时，记录达到终点的最小步数
                minStep = step;
                endWordPos.add(front);
            }
            List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());

            for (int i = 0; i < neighbors.size(); i++) {
                // 节点没被访问，或另一条最短路径
                if (!visit.containsKey(neighbors.get(i))
                        || visit.get(neighbors.get(i)) == step + 1) {
                    visit.put(neighbors.get(i), step + 1);
                    queue.add(new QueueItem(neighbors.get(i), front, step + 1));
                }
            }
            front++;
        }
    }

    public void constructGraph(String beginWord, List<String> wordList, Map<String, List<String>> graph) {
        // 构造用临接表表示的图结构
        int hasBeginWord = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                hasBeginWord = 1;
            }
        }
        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isConnection(wordList.get(i), wordList.get(j))) {
                    List<String> list1 = graph.getOrDefault(wordList.get(i), new ArrayList<>());
                    list1.add(wordList.get(j));
                    graph.put(wordList.get(i), list1);

                    List<String> list2 = graph.getOrDefault(wordList.get(j), new ArrayList<>());
                    list2.add(wordList.get(i));
                    graph.put(wordList.get(j), list2);
                }
            }
            if (hasBeginWord == 0 && isConnection(beginWord, wordList.get(i))) {
                List<String> list1 = graph.getOrDefault(wordList.get(i), new ArrayList<>());
                list1.add(beginWord);
                graph.put(wordList.get(i), list1);

                List<String> list2 = graph.getOrDefault(beginWord, new ArrayList<>());
                list2.add(wordList.get(i));
                graph.put(beginWord, list2);
            }
        }
    }

    public boolean isConnection(String word1, String word2) {
        int differentCharCount = 0;
        int length = word1.length();
        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentCharCount++;
            }
        }
        return differentCharCount == 1;
    }

    class QueueItem {
        /**
         * 搜索节点
         */
        public String node;

        /**
         * 前驱节点在队列中的位置
         */
        public int parentPos;

        /**
         * 到达当前节点的步数
         */
        public int step;

        public QueueItem(String node, int parentPos, int step) {
            this.node = node;
            this.parentPos = parentPos;
            this.step = step;
        }
    }
}
