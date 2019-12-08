package com.hjx.leetcode.problem0187;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findRepeatedDnaSequences() {
        Solution solution = new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> stringList = solution.findRepeatedDnaSequences(s);
        // ans = ["AAAAACCCCC", "CCCCCAAAAA"]
        System.out.println(stringList);
    }
}