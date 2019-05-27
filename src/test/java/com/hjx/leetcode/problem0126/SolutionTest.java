package com.hjx.leetcode.problem0126;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findLadders() {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Lists.newArrayList("hot","dot","dog","lot","log","cog");
        System.out.println(solution.findLadders(beginWord,endWord,wordList));
    }
}