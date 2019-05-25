package com.hjx.leetcode.problem0051;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solveNQueens() {
        Solution solution = new Solution();
        List<List<String>> ans = solution.solveNQueens(4);
        System.out.println(ans);
    }
}