package com.hjx.leetcode.problem2062;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testCountVowelSubstrings() {
        Solution solution = new Solution();
        String word = "cuaieuouac";
        int res = solution.countVowelSubstrings(word);
        Assert.assertEquals(7, res);
    }
}
