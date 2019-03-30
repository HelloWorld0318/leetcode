package com.hjx.leetcode.problem0225;

import org.junit.Test;

public class MyStackTest {

    @Test
    public void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

}