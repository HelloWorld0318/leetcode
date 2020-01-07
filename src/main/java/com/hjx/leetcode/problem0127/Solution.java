package com.hjx.leetcode.problem0127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        constructGraph(beginWord, wordList, graph);
        return bfsGraph(beginWord, endWord, graph);
    }

    public int bfsGraph(String beginWord, String endWord, Map<String, List<String>> graph) {
        Set<String> hasVisitedWord = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        hasVisitedWord.add(beginWord);
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int step = pair.step;
            hasVisitedWord.add(word);
            if (endWord.equals(word)) {
                return step;
            }
            List<String> neighbors = graph.getOrDefault(word, new ArrayList<>());
            for (int i = 0; i < neighbors.size(); i++) {
                if (!hasVisitedWord.contains(neighbors.get(i))) {
                    queue.offer(new Pair(neighbors.get(i), step + 1));
                }
            }
        }
        return 0;
    }

    public void constructGraph(String beginWord, List<String> wordList, Map<String, List<String>> graph) {
        // 构造用临接表表示的图结构
        wordList.add(beginWord);
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

    class Pair {
        public String word;
        public int step;

        public Pair(String word, int step) {
            this.step = step;
            this.word = word;
        }
    }
}
