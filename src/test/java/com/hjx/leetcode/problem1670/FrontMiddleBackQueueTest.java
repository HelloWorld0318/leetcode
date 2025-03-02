package com.hjx.leetcode.problem1670;

import org.junit.Test;

public class FrontMiddleBackQueueTest {

    @Test
    public void testPopBack() {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        //测试用例:["FrontMiddleBackQueue","pushFront","pushBack","pushMiddle","pushMiddle","popFront","popMiddle","popMiddle","popBack","popFront"]
//			[[],[1],[2],[3],[4],[],[],[],[],[]]
//        期望结果:[null,null,null,null,null,1,3,4,2,-1]
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushMiddle(4);
        System.out.println(queue.popFront());//1
        System.out.println(queue.popMiddle());//3
        System.out.println(queue.popMiddle());//4
        System.out.println(queue.popBack());//2
        System.out.println(queue.popFront());//-1
    }
}