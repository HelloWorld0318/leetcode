package com.hjx.leetcode.data.structure.hashmap;

public class CycleQueue<T> {

    private Integer MAXSIZE = 100;
    private Object[] arr;
    private int front;
    private int rear;

    public CycleQueue() {
        arr = new Object[MAXSIZE];
        front = 0;
        rear = 0;
    }

    public void add(T object) {
        if ((rear + 1) % MAXSIZE == front) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = object;
        rear = (rear + 1) % MAXSIZE;
    }

    public void remove() {
        if (rear == front) {
            throw new RuntimeException("队列为空");
        }
        // e为要出队的元素
        T e = (T) arr[front];
        front = (front + 1) % MAXSIZE;
    }

}
