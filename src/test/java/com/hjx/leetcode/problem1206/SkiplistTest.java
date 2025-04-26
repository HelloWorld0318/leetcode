package com.hjx.leetcode.problem1206;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkiplistTest {

    Skiplist skiplist = new Skiplist();

    @Test
    public void testSearch() {
        skiplist.print();
        boolean res = skiplist.search(50);
        Assert.assertTrue(res);
    }

    @Before
    public void add() {
        skiplist.add(30);
        skiplist.add(40);
        skiplist.add(50);
        skiplist.add(60);
        skiplist.add(70);
        skiplist.add(90);
    }
}