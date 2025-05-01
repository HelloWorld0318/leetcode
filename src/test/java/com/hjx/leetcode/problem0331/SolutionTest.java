package com.hjx.leetcode.problem0331;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testIsValidSerialization() {
        Solution solution = new Solution();
        String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean res = solution.isValidSerialization(preOrder);
        Assert.assertTrue(res);
    }

}