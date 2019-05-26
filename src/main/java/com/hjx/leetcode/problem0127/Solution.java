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

    private int bfsGraph(String beginWord, String endWord, Map<String, List<String>> graph) {
        Queue<Pair> searchQueue = new LinkedList<>();
        Set<String> hasVisitedWord = new HashSet<>();
        searchQueue.offer(new Pair(beginWord, 1));
        hasVisitedWord.add(beginWord);

        while (!searchQueue.isEmpty()) {
            String word = searchQueue.peek().word;
            int step = searchQueue.poll().step;
            hasVisitedWord.add(word);
            if (word.equals(endWord)) {
                return step;
            }

            List<String> neighbors = graph.getOrDefault(word, new ArrayList<>());
            for (int i = 0; i < neighbors.size(); i++) {
                if (!hasVisitedWord.contains(neighbors.get(i))) {
                    searchQueue.offer(new Pair(neighbors.get(i), step + 1));
                }
            }
        }
        return 0;
    }

    private void constructGraph(String beginWord, List<String> wordList, Map<String, List<String>> graph) {
        // 使用邻接表表示图
        wordList.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (connnect(wordList.get(i), wordList.get(j))) {
                    List<String> listI = graph.getOrDefault(wordList.get(i), new ArrayList<>());
                    listI.add(wordList.get(j));
                    graph.put(wordList.get(i), listI);

                    List<String> listJ = graph.getOrDefault(wordList.get(j), new ArrayList<>());
                    listJ.add(wordList.get(i));
                    graph.put(wordList.get(j), listJ);
                }
            }
        }
    }

    private boolean connnect(String word1, String word2) {
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
        String word;
        int step;

        Pair(String word, int step) {
            this.step = step;
            this.word = word;
        }
    }
}
