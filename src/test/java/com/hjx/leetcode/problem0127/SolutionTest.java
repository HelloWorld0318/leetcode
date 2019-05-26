package com.hjx.leetcode.problem0127;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void ladderLength() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Lists.newArrayList("hot", "dot", "dog", "lot", "log");
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.ladderLength(beginWord, endWord, wordList));
    }
}